package com.tbl.faq.services;

import com.tbl.faq.domain.dao.TblFaq;
import com.tbl.faq.domain.dto.FaqInfo;
import com.tbl.faq.repository.FaqRepository;

import com.tbl.faq.utils.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FaqServiceImpl implements FaqService {

    private FaqRepository faqRepository;
    private ModelMapper modelMapper;

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("restful-unit");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    public FaqServiceImpl() {}

    @Autowired
    public FaqServiceImpl(EntityManager em, FaqRepository faqRepository, ModelMapper modelMapper) {
        this.em = em;
        this.faqRepository = faqRepository;
        this.modelMapper = modelMapper;
    }

    @Override @Transactional
    public List<FaqInfo> getFaqList(Integer page, Integer size) {
        Page<TblFaq> faqBoard = faqRepository.findAll(PageRequest.of(page, size));
        Validate.isTrue(!faqBoard.isEmpty(), "결과가 없습니다.");

        List<FaqInfo> faqList = faqBoard.getContent().stream().map(faq ->
                sourceToDestination(faq, new FaqInfo())
        ).collect(Collectors.toList());

        return faqList;
    }

    @Override
    public <R, T> T sourceToDestination(R source, T destination){
        System.out.println("source : " + source);
        System.out.println("destination : " + destination);
        modelMapper.map(source, destination);
        return destination;
    }

    @Override
    public void saveFaq(TblFaq faq) {
        faqRepository.save(faq);
    }

    @Override
    public List<TblFaq> findAll(){
        List<TblFaq> list = faqRepository.findAll();

        for(TblFaq faq : list){
            System.out.println(faq.toString());
        }
        return list;
    }

    @Override
    public Optional<TblFaq> findOne(int id){
        Optional<TblFaq> faq = faqRepository.findById(id);
        TblFaq res = faq.orElse(new TblFaq());
        int cnt = res.getViewCnt();
        res.setViewCnt(++cnt);
        faqRepository.save(res);
        faq = Optional.of(res);
        return faq;
    }

    @Override
    public void updateFaq(int id, TblFaq faq){
        System.err.println("FaqService faqService");
        System.out.println(faq.toString());
        faqRepository.findById(id).map( faqs -> {
            faqs.setCategoryId(faq.getCategoryId());
            faqs.setSubject(faq.getSubject());
            faqs.setContent(faq.getContent());
            faqs.setModDate(faq.getModDate());
            return faqRepository.save(faqs);
        }).orElseGet(() -> {
            faq.setId(id);
            return faqRepository.save(faq);
        });
    }

    @Override
    public void deleteFaq(int id) {
        System.err.println("FaqService deleteFaq");
        faqRepository.deleteById(id);
    }

    @Override
    public List<TblFaq> searchFaq(String keyword) {
        String jpql = "select f from TblFaq f where f.subject like '%" + keyword + "%'";
        tx.begin();
        try{ // 1.
            System.err.println("FaqService faqService");
            List<TblFaq> result = em.createQuery(jpql, TblFaq.class)
                    .getResultList();
            tx.commit();
            return result;
        }catch(Exception e){
            tx.rollback();
        }//finally {
        //em.close();
        //} // faqCRUD.http로 반복적으로 테스트 하기 위해 EntityManager를 닫지 않음
        return null;
    }

    @Override
    public List<TblFaq> sortFaqAsc() {
        List<TblFaq> list = faqRepository.findAll(Sort.by(Sort.Direction.ASC, "regDate"));
        return list;
    }

    @Override
    public List<TblFaq> sortFaqDesc() {
        List<TblFaq> list = faqRepository.findAll(Sort.by(Sort.Direction.DESC, "regDate"));
        return list;
    }

//    @Override
//    public void close() {
//        em.close();
//        emf.close();
//    }
}

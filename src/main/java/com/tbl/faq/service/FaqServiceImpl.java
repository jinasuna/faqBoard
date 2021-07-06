package com.tbl.faq.service;

import com.tbl.faq.entity.Faq;
import com.tbl.faq.entity.FaqResult;
import com.tbl.faq.repository.FaqRepository;

import com.tbl.faq.util.Validate;
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
    public List<FaqResult> getFaqList(Integer page, Integer size) {
        Page<Faq> faqBoard = faqRepository.findAll(PageRequest.of(page, size));
        Validate.isTrue(!faqBoard.isEmpty(), "결과가 없습니다.");

        List<FaqResult> faqList = faqBoard.getContent().stream().map(faq ->
                sourceToDestination(faq, new FaqResult())
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
    public void saveFaq(Faq faq) {
        faqRepository.save(faq);
    }

    @Override
    public List<Faq> findAll(){
        List<Faq> list = faqRepository.findAll();

        for(Faq faq : list){
            System.out.println(faq.toString());
        }
        return list;
    }

    @Override
    public Optional<Faq> findOne(int id){
        Optional<Faq> faq = faqRepository.findById(id);
        Faq res = faq.orElse(new Faq());
        int cnt = res.getViewCnt();
        res.setViewCnt(++cnt);
        faqRepository.save(res);
        faq = Optional.of(res);
        return faq;
    }

    @Override
    public void updateFaq(int id, Faq faq){
        System.err.println("FaqService faqService");
        System.out.println(faq.toString());
        //카테고리 제목 내용 수정일
        faqRepository.findById(id).map( faqs -> {
            faqs.setCategoryId(faq.getCategoryId());
            faqs.setSubject(faq.getSubject());
            faqs.setContent(faq.getContent());
            faqs.setModDate(faq.getModDate());
            return faqRepository.save(faqs);
        }).orElseGet(() -> { // 없으면 지금 이 id로 새로 하나 만들어라
            faq.setId(id);
            return faqRepository.save(faq);
        });
    }

    @Override
    public void deleteFaq(int id) {
        System.err.println("FaqService deleteFaq");
        faqRepository.deleteById(id);
    }

    // select * from tbl_faq where sbj like '%출%';
    @Override
    public List<Faq> searchFaq(String keyword) {
        String jpql = "select f from Faq f where f.subject like '%" + keyword + "%'";
        tx.begin();
        try{ // 1.
            System.err.println("FaqService faqService");
            List<Faq> result = em.createQuery(jpql, Faq.class)
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
    public List<Faq> sortFaqAsc() {
        List<Faq> list = faqRepository.findAll(Sort.by(Sort.Direction.ASC, "regDate"));
        return list;
    }

    @Override
    public List<Faq> sortFaqDesc() {
        List<Faq> list = faqRepository.findAll(Sort.by(Sort.Direction.DESC, "regDate"));
        return list;
    }

//    @Override
//    public void close() {
//        em.close();
//        emf.close();
//    }
}

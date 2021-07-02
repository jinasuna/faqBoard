package com.tbl.faq.service;

import com.tbl.faq.entity.Faq;
import com.tbl.faq.repository.FaqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Service
public class FaqServiceImpl implements FaqService {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("restful-unit");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    private FaqRepository faqRepository;

    public FaqServiceImpl(EntityManager em) {
    }

    @Autowired
    public void setProductRepository(FaqRepository faqRepository) {
        this.faqRepository = faqRepository;
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
        }).orElseGet(() -> {
            // 이 로직을 이해해야해
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
        return null;
    }

    @Override
    public List<Faq> sortFaqDesc() {
        return null;
    }

}

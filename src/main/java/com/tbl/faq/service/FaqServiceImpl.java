package com.tbl.faq.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.tbl.faq.entity.Faq;
import com.tbl.faq.repository.FaqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Service
public class FaqServiceImpl implements FaqService {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("restful");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    private final JPAQueryFactory queryFactory;

    private FaqRepository faqRepository;

    public FaqServiceImpl(EntityManager em) {
        queryFactory = new JPAQueryFactory(em);
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

    // select * from tbl_faq where sbj like '출%';
    @Override
    public List<Faq> searchFaq(String keyword) {
        String jpql = "select f from Faq f where f.subject like '%" + keyword + "'%''";
        tx.begin();
        try{ // 1.
            List<Faq> result1 = em.createQuery(jpql, Faq.class)
                    .getResultList();
            // 이 받아온 값을 어떻게 할지 생각해 보자
            for (Faq faq : result1){
                System.out.println("faq.subject : " + faq.getSubject() + "faq.content : " + faq.getContent());
            }
            tx.commit();
            return result1;

            // 2.query-dsl을 하고싶었으나..

//            List<Faq> result2 = queryFactory
//                    .select()

        }catch(Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
        return null;
    }

    @Override
    public List<Faq> findAllByOrderByDateAsc() {
        return faqRepository.findAllByOrderByRegDateAsc();
    }

    @Override
    public List<Faq> findAllByOrderByDateDesc() {
        return faqRepository.findAllByOrderByRegDateDesc();
    }

//    @Override
//    public void close() {
//        em.close();
//        emf.close();
//    }
}

package com.tbl.faq.service;

import com.tbl.faq.entity.Faq;
import com.tbl.faq.repository.FaqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FaqServiceImpl implements FaqService {

    private FaqRepository faqRepository;

    @Autowired
    public void setProductRepository(FaqRepository faqRepository) {
        this.faqRepository = faqRepository;
    }

    @Override
    public void saveFaq(Faq faq) {
        faqRepository.save(faq);
    }

//    @Override
//    public Faq createFaq(Faq faq) {
//        System.err.println("FaqService createFaq");
//        System.out.println(faq.toString());
//        Faq res = faqRepository.save(faq);
//        System.out.println(res);
//        return res;
//    }

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
        System.out.println(faq);
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
    public List<Faq> findAllByOrderByDateAsc() {
        return faqRepository.findAllByOrderByRegDateAsc();
    }

    @Override
    public List<Faq> findAllByOrderByDateDesc() {
        return faqRepository.findAllByOrderByRegDateDesc();
    }

}

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
    public List<Faq> findAll(){
        List<Faq> list = faqRepository.findAll();

        for(Faq faq : list){
            System.out.println(faq.toString());
        }
        return list;
    }

    @Override
    public Optional<Faq> findOne(Long id){
        Optional<Faq> faq = faqRepository.findById(Math.toIntExact(id));
        System.out.println(faq);
        return faq;
    }

    @Override
    public Faq createFaq(Faq faq) { // API test 할 때 어떤 데이터를 넘겨줘야 하지? 어떻게 호출해서 솩인할수 있을까?
        System.err.println("FaqService createFaq");
        System.out.println(faq.toString());
        Faq res = faqRepository.save(faq);
        System.out.println(res);
        return res;
    }

    @Override
    public void updateFaq(long id, Faq faq){
        System.err.println("FaqService faqService");
        System.out.println(faq.toString());
        //카테고리 제목 내용 수정일
        faqRepository.findById((int) id).map( faqs -> {
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
    public void deleteFaq(long id) {
        System.err.println("FaqService deleteFaq");
        faqRepository.deleteById((int) id);
    }
/////////////////////
    @Override
    public void saveFaq(Faq faq) {
        faqRepository.save(faq);
    }
    //카테고리 제목 내용 수정일
//    @Override
//    public void saveFaq(int categoryId, String subject, String content, Date modDate) {
//        faqRepository.save(updated);
//    }

    //카테고리 제목 내용 수정일
    @Override
    public void updateFaq(long id, int categoryId, String subject, String content, Date modDate) {
        Faq updated = faqRepository.findById((int) id).get();
        updated.setCategoryId(categoryId);
        updated.setSubject(subject);
        updated.setContent(content);
        updated.setModDate(modDate);
        faqRepository.save(updated);
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

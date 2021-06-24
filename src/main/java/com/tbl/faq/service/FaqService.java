package com.tbl.faq.service;

import com.tbl.faq.entity.Faq;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface FaqService {
    public List<Faq> findAll();
    public Optional<Faq> findOne(Long id);
    public Faq createFaq(Faq faq);
    public void updateFaq(long id, Faq faq);
    public void deleteFaq(long id);

    public void saveFaq(Faq faq);
    //카테고리 제목 내용 수정일
    public void updateFaq(long id, int categoryId, String subject, String content, Date modDate);
    public List<Faq> findAllByOrderByDateAsc();
    public List<Faq> findAllByOrderByDateDesc();
}

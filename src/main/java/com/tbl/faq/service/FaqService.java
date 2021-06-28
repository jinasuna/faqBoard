package com.tbl.faq.service;

import com.tbl.faq.entity.Faq;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface FaqService {
    public void saveFaq(Faq faq);
    //public Faq createFaq(Faq faq);
    public List<Faq> findAll();
    public Optional<Faq> findOne(int id);
    // public int updateViewCnt();
    public void updateFaq(int id, Faq faq);
    public void deleteFaq(int id);
    public List<Faq> searchFaq(String keyword);
    public List<Faq> findAllByOrderByDateAsc();
    public List<Faq> findAllByOrderByDateDesc();
//    public void close();
}

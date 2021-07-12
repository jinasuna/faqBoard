package com.tbl.faq.services;

import com.tbl.faq.domain.dao.TblFaq;

import java.util.List;
import java.util.Optional;

import com.tbl.faq.domain.dto.FaqInfo;
import org.springframework.stereotype.Service;

@Service
public interface FaqService {
    public void saveFaq(TblFaq faq);
    public List<TblFaq> findAll();
    public Optional<TblFaq> findOne(int id);
    public void updateFaq(int id, TblFaq faq);
    public void deleteFaq(int id);
    public List<TblFaq> searchFaq(String keyword);
    public List<TblFaq> sortFaqAsc();
    public List<TblFaq> sortFaqDesc();
    public List<FaqInfo> getFaqList(Integer page, Integer size);
    public <R, T> T sourceToDestination(R source, T destination);
//    public void close();
}

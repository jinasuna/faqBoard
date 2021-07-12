package com.tbl.faq.controllers;

import com.tbl.faq.config.ApplicationConfig;
import com.tbl.faq.domain.dao.TblFaq;
import com.tbl.faq.services.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api")
public class FaqController {

    private FaqService faqService;
    // 기본 sort 설정은 오름차순
    private String sortDateMethod = "DESC";

    ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

    @Autowired
    public void setFaqService(FaqService faqService) {
        this.faqService = faqService;
    }
    // Create
    @PostMapping("/faqSave")
    public void saveFaq(@RequestBody final TblFaq faq) {
        System.err.println("FaqController createFaq");
        faqService.saveFaq(faq);
    }

    // List 조회
    @GetMapping("/{page}/{size}")
    public Object getFaqList(@PathVariable("page") Integer page, @PathVariable("size") Integer size) throws Exception{
        System.err.println("FaqController getFqaList");
        return faqService.getFaqList(page, size);
    }

    // Read 단건 조회
    @GetMapping(path = "/faqList/{id}")
    public Optional<TblFaq> getOneFaq(@PathVariable("id") int id) {
        System.err.println("FaqController getOneFaq");
        return faqService.findOne(id);
    }

    // Update
    @PostMapping("/updateFaq/{id}")
    public TblFaq updateFaq(@PathVariable("id") int id,
                            @RequestBody final TblFaq faq) {
        System.err.println("FaqController updateFaq");
        faqService.updateFaq(id,faq);
        return faq;
    }

    // Delete
    @DeleteMapping("/deleteFaq/{id}")
    public void deleteItem(@PathVariable("id") int id) {
        System.err.println("FaqController deleteFaq");
        faqService.deleteFaq(id);
    }

    // Search
    @GetMapping("searchFaq/{keyword}")
    public List<TblFaq> searchFaq(@PathVariable("keyword") String keyword){
        System.err.println("FaqController searchFaq");
        return faqService.searchFaq(keyword);
    }

    // 정렬 - 기본 : 오름차순
    @GetMapping("/sortFaq/{sortDate}")
    public List<TblFaq> sortFaq(@PathVariable String sortDate) {
        sortDateMethod = sortDate;
        System.out.println("sortFaq sortDateMethod : " + sortDateMethod);
        List<TblFaq> faqList = sortList(sortDateMethod);
        return faqList;
    }

    @GetMapping("/faqList")
    public List<TblFaq> sortList(String sortDateMethod) { // 리다이렉트 받을때 model에 아마도 sortDateMethod를 가져오는듯
        List<TblFaq> faqList = filterAndSort();
        System.out.println("sortList sortDateMethod : " + sortDateMethod);
        return faqList;
    }

    private List<TblFaq> filterAndSort() {
        List<TblFaq> faqList = null;
        switch (sortDateMethod) {
            case "ASC":
                faqList = faqService.sortFaqAsc();
                break;
            case "DESC":
                faqList = faqService.sortFaqDesc();
                break;
        }
        return faqList;
    }
}

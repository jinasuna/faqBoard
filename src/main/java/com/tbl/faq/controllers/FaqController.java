package com.tbl.faq.controllers;

import com.tbl.faq.entity.Faq;
import com.tbl.faq.service.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.constraints.Min;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api")
public class FaqController {

    private FaqService faqService;
    // 기본 sort 설정은 오름차순
    private String sortDateMethod = "ASC";

    @Autowired
    public void setFaqService(FaqService faqService) {
        this.faqService = faqService;
    }

// 컴포넌트빌더 쓰는방식..뭔가 이상하고..어렵다..더 알고나서 써야할듯
//    @PostMapping("/faqList")
//    public Faq createFaq(@RequestBody final Faq faq, final UriComponentsBuilder uriComponentsBuilder) {
//        System.err.println("FaqController createFaq");
//        return faqService.createFaq(faq);
//    }

    // Create
    @PostMapping("/faqSave")
    public void saveFaq(@RequestBody final Faq faq) {
        System.err.println("FaqController createFaq");
        faqService.saveFaq(faq);
    }

    // 의문. 페이징이 되었다 하더라도, 이 결과를 어떻게 확인하지? -> 여기서 url로 던져야지!
    // List 조회
    @GetMapping("/{page}")
    public List<Faq> getFaqList(@PathVariable("page") @Min(0)Integer page) {
        System.err.println("FaqController getFqaList");
        return faqService.getFaqList(page);
    }

    // Read 단건 조회
    @GetMapping(path = "/faqList/{id}")
    public Optional<Faq> getOneFaq(@PathVariable("id") int id) {
        System.err.println("FaqController getOneFaq");
        return faqService.findOne(id);
    }

    // Update
    @PostMapping("/updateFaq/{id}")
    public Faq updateFaq(@PathVariable("id") int id,
                            @RequestBody final Faq faq) {
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
    public List<Faq> searchFaq(@PathVariable("keyword") String keyword){
        System.err.println("FaqController searchFaq");
        return faqService.searchFaq(keyword);
    }

    // 정렬 - 기본 : 오름차순
    @GetMapping("/sortFaq/{sortDate}")
    public void sortFaq(@PathVariable String sortDate) {
        sortDateMethod = sortDate;
        sortList();
    }

    @GetMapping("/")
    public List<Faq> sortList() { // 리다이렉트 받을때 model에 아마도 sortDateMethod를 가져오는듯
        //List<Faq> faqList = filterAndSort();
        List<Faq> faqList = faqService.findByOrderByDateAsc();
        return faqList;
    }

    // sort메서드
    private List<Faq> filterAndSort() {
        List<Faq> faqList = null;
        switch (sortDateMethod) {
            case "ASC": // 이걸 구분하려면
                faqList = faqService.sortFaqAsc();
                break;
            case "DESC":
                faqList = faqService.sortFaqDesc();
                break;
        }
        return faqList;
    }
}

package com.tbl.faq.controllers;

import com.tbl.faq.entity.Faq;
import com.tbl.faq.service.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api")
public class FaqController {

    private FaqService faqService;
    private String sortDateMethod = "ASC";

    @Autowired
    public void setFaqService(FaqService faqService) {
        this.faqService = faqService;
    }

    // 컴포넌트필더 쓰는방식..뭔가 이상하고..어렵다..더 알고나서 써야할듯
    @PostMapping("/faqList")
    public Faq createFaq(@RequestBody final Faq faq, final UriComponentsBuilder uriComponentsBuilder) {
        System.err.println("FaqController createFaq");
        return faqService.createFaq(faq);
    }

//    @PostMapping("/faqSave")
//    public void saveFaq(@RequestBody final Faq faq) {
//        System.err.println("FaqController createFaq");
//        faqService.saveFaq(faq);
//    }

    @PostMapping("/faqSave")
    public void saveFaq(@RequestBody final Faq faq) {
        System.err.println("FaqController createFaq");
        faqService.saveFaq(faq);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Faq> getFaqList() {
        System.err.println("FaqController getFqaList");
        return faqService.findAll();
    }

    @GetMapping(path = "/faq/{id}")
    public Optional<Faq> getOneFaq(@PathVariable("id") long id) {
        System.err.println("FaqController getOneFaq");
        return faqService.findOne(id);
    }

    //카테고리 제목 내용 수정일
    @PostMapping("/update/{id}")
    public String updateFaq(@PathVariable("id") long id,
                            @RequestBody final Faq faq,
                            final UriComponentsBuilder uriComponentsBuilder) {
        System.err.println("FaqController updateFaq");
        faqService.updateFaq(id,faq);
        return "redirect:/";
    }

    @DeleteMapping("/faqList/{id}")
    public void deleteItem(@PathVariable("id") long id) {
        System.err.println("FaqController deleteFaq");
        faqService.deleteFaq(id);
    }

    // 좀 더 익숙한 방식으로 다시 해보자
    // 정렬 보여주는 리스트..여야 하는데 뭔지도모르는 index를 리턴하네 문자열로 ㅜㅜ
    // sortChoose, filterAndSort 두 개를 거쳐서 알게된 정보로 model을 설정한다,,?
    @GetMapping("/faqList")
    public String list(Model model) {
        List<Faq> faqList = filterAndSort();
        model.addAttribute("faq", faqList);
        model.addAttribute("sort", sortDateMethod);
        return "index";
    }

    @GetMapping("/sort/{sortDate}")
    public String sortChoose(@PathVariable String sortDate) {
        sortDateMethod = sortDate;
        return "redirect:/faqList";
    }

    private List<Faq> filterAndSort() {
        List<Faq> faqList = null;
        switch (sortDateMethod) {
            case "ASC":
                faqList = faqService.findAllByOrderByDateAsc();
                break;
            case "DESC":
                faqList = faqService.findAllByOrderByDateDesc();
                break;
        }
        return faqList;
    }

}

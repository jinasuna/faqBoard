package com.tbl.faq.controllers;

import com.tbl.faq.entity.Faq;
import com.tbl.faq.service.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Date;
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

    // List 조회
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Faq> getFaqList() {
        System.err.println("FaqController getFqaList");
        return faqService.findAll();
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
        // return "redirect:/"; // List<Faq> getFaqList() 호출
        return faq;
    }

    // Delete
    // 삭제 서비스 메서드
    @DeleteMapping("/deleteFaq/{id}")
    public void deleteItem(@PathVariable("id") int id) {
        System.err.println("FaqController deleteFaq");
        faqService.deleteFaq(id);
    }

    // ->viewcnt처리해야 함
    // -> 정렬 처리해야 함(오름차순+내림차순)
    // 검색 기능 넣어야 함

    // 좀 더 익숙한 방식으로 다시 해보자
    // 정렬 보여주는 리스트..여야 하는데 뭔지도모르는 index를 리턴하네 문자열로 ㅜㅜ
    // sortChoose, filterAndSort 두 개를 거쳐서 알게된 정보로 model을 설정한다,,?
    @GetMapping("/faqList")
    public String list(Model model) {
        List<Faq> faqList = filterAndSort(); // string값을 넘겨줘야 하지 않을까?
        model.addAttribute("faq", faqList);
        model.addAttribute("sort", sortDateMethod);
        return "index";
    }

    @GetMapping("/sort/{sortDate}") // 얘네 셋이서 어떻게 주고받아야 할까?
    public String sortChoose(@PathVariable String sortDate) {
        sortDateMethod = sortDate;
        return "redirect:/faqList";
    }

    private List<Faq> filterAndSort() {// string값을 넘겨줘야 하지 않을까?
        List<Faq> faqList = null;
        switch (sortDateMethod) {
            case "ASC": // 이걸 구분하려면
                faqList = faqService.findAllByOrderByDateAsc();
                break;
            case "DESC":
                faqList = faqService.findAllByOrderByDateDesc();
                break;
        }
        return faqList;
    }

}

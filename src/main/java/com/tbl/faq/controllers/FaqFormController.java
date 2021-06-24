package com.tbl.faq.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FaqFormController {
    @RequestMapping("/com/tbl/faq/new-form")
    public ModelAndView process(){
        return new ModelAndView("new-form");
    }
}

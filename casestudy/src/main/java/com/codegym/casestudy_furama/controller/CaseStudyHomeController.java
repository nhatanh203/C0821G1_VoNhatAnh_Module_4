package com.codegym.casestudy_furama.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CaseStudyHomeController {
    @GetMapping("")
    public String home(Model model){
        return "home/home";
    }
}

package com.codegym.controller;

import com.codegym.model.EmailBox;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailBoxController {

    @GetMapping("/email")
    public String email(Model model) {
        String[] language = {"English", "Vietnamese", "Japanese", "Chinese"};
        int[] pageSize = {5, 10, 15, 25, 50, 100};
        model.addAttribute("language", language);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("emailBox", new EmailBox());
        return "email_box";
    }

    @PostMapping("/config")
    public String config(@ModelAttribute("emailBox") EmailBox emailBox, Model model){
        model.addAttribute("language", emailBox.getLanguage());
        model.addAttribute("pageSize", emailBox.getPageSize());
        model.addAttribute("spamFilter", emailBox.getSpamFilter());
        model.addAttribute("signature", emailBox.getSignature());
        return "config_email";
    }
}

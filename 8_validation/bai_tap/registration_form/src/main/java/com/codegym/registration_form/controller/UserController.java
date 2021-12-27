package com.codegym.registration_form.controller;

import com.codegym.registration_form.dto.UserDTO;
import com.codegym.registration_form.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/")
    public String showListAcount(Model model) {
        model.addAttribute("users", this.userService.findAll());
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user", new UserDTO());
        return "create";
    }

    @PostMapping("/create")
    public String save(@Valid @ModelAttribute("user") UserDTO userDto,
                       BindingResult bindingResult, RedirectAttributes redirect) {
        new UserDTO().validate(userDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "create";
        } else {
            userService.save(userDto);
            redirect.addFlashAttribute("success", "Created new user complete !!");
            return "redirect:/";
        }
    }
}

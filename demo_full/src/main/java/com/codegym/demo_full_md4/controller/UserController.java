package com.codegym.demo_full_md4.controller;

import com.codegym.demo_full_md4.model.User;
import com.codegym.demo_full_md4.repository.IUserTypeRepository;
import com.codegym.demo_full_md4.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService iUserSer;

    @Autowired
    IUserTypeRepository iUserTypeRepo;

    @GetMapping
    public String ListPage(Model model, @RequestParam(value = "page", defaultValue = "0") Integer page) {
        Page<User> userList = iUserSer.findAll(PageRequest.of(page, 2));
        model.addAttribute("userList", userList);
        return "home_user";
    }

    @GetMapping("/create")
    public String create(Model model) {
        String[] gender = {"Male", "Female"};
        model.addAttribute("user", new User());
        model.addAttribute("genderList", gender);
        model.addAttribute("userTypeList", iUserTypeRepo.findAll());
        return "create_user";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("user") User user,
                       BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        new User().validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            String[] gender = {"Male", "Female"};
            model.addAttribute("genderList", gender);
            model.addAttribute("userTypeList", iUserTypeRepo.findAll());
            return "create_user";
        }else {
            iUserSer.save(user);
            redirectAttributes.addFlashAttribute("message", "Create Complete !");
            return "redirect:/user";
        }
    }

    @GetMapping("/edit_parameter")
    public String showEditParam(@RequestParam(name = "id") Integer id, Model model) {
        model.addAttribute("user", iUserSer.findById(id));
        model.addAttribute("userTypeList", iUserTypeRepo.findAll());
        String[] gender = {"Male", "Female"};
        model.addAttribute("genderList", gender);
        return "edit_user";
    }

//    @PostMapping("/edit")
//    public String edit(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
//        iUserSer.save(user);
//        redirectAttributes.addFlashAttribute("message", "Edit success");
//        return "redirect:/user";
//    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute("user") User user, BindingResult bindingResult,  RedirectAttributes redirectAttributes, Model model) {
        new User().validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            model.addAttribute("userTypeList", iUserTypeRepo.findAll());
            String[] gender = {"Male", "Female"};
            model.addAttribute("genderList", gender);
            return "edit_user";
        }
        iUserSer.save(user);
        redirectAttributes.addFlashAttribute("message", "Edit Complete !");
        return "redirect:/user";
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "search") String name, Model model) {
        List<User> user = iUserSer.findByName(name);
        model.addAttribute("userList", user);
        return "search_user";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") Integer id) {
        iUserSer.remove(id);
        return "redirect:/user";
    }

    @GetMapping("{id}/view")
    public String view(@PathVariable("id") Integer id, Model model) {
        User user = iUserSer.findById(id);
        model.addAttribute("user", user);
        return "view_user";
    }
}

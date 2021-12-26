package com.codegym.blog_application.controller;

import com.codegym.blog_application.model.Category;
import com.codegym.blog_application.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService cateService;

    @GetMapping({"", "/list"})
    public ModelAndView index() {
        return new ModelAndView("index", "category", cateService.findAll());
    }

    @GetMapping("/view")
    public String view(@RequestParam("id") String id, Model model) {
        Category category = cateService.findById(id);
        model.addAttribute("category", category);
        return "category/view";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("category", new Category());
        return "category/create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute("blog") Category cate, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "New Category CREATED");
        cateService.save(cate);
        return "redirect:/category/list";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView viewEditBlog(@PathVariable String id) {
        return new ModelAndView("edit", "category", cateService.findById(id));
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute("blog") Category cate) {
        cateService.save(cate);
        ModelAndView modelAndView = new ModelAndView("edit", "category", cate);
        modelAndView.addObject("message", "Updated COMPLETE!");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView viewDelete(@PathVariable String id) {
        return new ModelAndView("delete", "category", cateService.findById(id));
    }

    @PostMapping("/delete")
    public ModelAndView delete(@ModelAttribute("blog") Category cate) {
        cateService.remove(String.valueOf(cate.getId()));
        ModelAndView modelAndView = new ModelAndView("index", "message", "Deleted Successfuly");
        return modelAndView;
    }

}

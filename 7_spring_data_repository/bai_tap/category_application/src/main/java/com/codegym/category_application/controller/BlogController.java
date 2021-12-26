package com.codegym.category_application.controller;

import com.codegym.category_application.model.Blog;
import com.codegym.category_application.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public ModelAndView index() {
        return new ModelAndView("index", "blogs", blogService.findAll());
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "New Blog CREATED");
        blogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Integer id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "view";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView viewEditBlog(@PathVariable int id) {
        return new ModelAndView("edit", "blog", blogService.findById(id));
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("edit", "blog", blog);
        modelAndView.addObject("message", "Updated COMPLETE!");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView viewDelete(@PathVariable int id) {
        return new ModelAndView("delete", "blog", blogService.findById(id));
    }

    @PostMapping("/delete")
    public ModelAndView delete(@ModelAttribute("blog") Blog blog) {
        blogService.remove(blog.getId());
        ModelAndView modelAndView = new ModelAndView("index", "message", "Deleted Successfuly");
        return modelAndView;
    }

}
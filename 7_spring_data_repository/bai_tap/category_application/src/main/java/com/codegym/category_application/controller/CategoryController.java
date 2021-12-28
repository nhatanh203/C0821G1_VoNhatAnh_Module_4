package com.codegym.category_application.controller;

import com.codegym.category_application.model.Category;
import com.codegym.category_application.service.ICategoryService;
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

    @GetMapping({"","/list"})
    public ModelAndView index() {
        Iterable<Category> categories = cateService.findAll();

        ModelAndView modelAndView = new ModelAndView("/category/index");
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

    @GetMapping("/view")
    public String view(@RequestParam("id") int id, Model model) {
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

    @GetMapping("{id}/edit")
    public String showEdit(@PathVariable(name = "id") int id, Model model) {
        model.addAttribute("category", cateService.findById(id));
        return "category/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("blog") Category category,RedirectAttributes redirectAttributes) {
        cateService.save(category);
        redirectAttributes.addFlashAttribute("message", "Edit success");
        return "redirect:/category/list";
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute("blog") Category cate) {
        cateService.save(cate);
        ModelAndView modelAndView = new ModelAndView("edit", "category", cate);
        modelAndView.addObject("message", "Updated COMPLETE!");
        return modelAndView;
    }

    @GetMapping("/delete")
    public String showDelete(@RequestParam(name = "id") int id, Model model) {
        model.addAttribute("category", cateService.findById(id));
        return "category/delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
        cateService.remove(category.getId());
        redirectAttributes.addFlashAttribute("message", "Delete Category successfully!");
        return "redirect:/category/list";
    }
}

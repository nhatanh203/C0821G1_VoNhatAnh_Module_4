package com.codegym.example_module.controller;

import com.codegym.example_module.model.Order;
import com.codegym.example_module.repository.IProductRepository;
import com.codegym.example_module.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    IOrderService iOrderSer;

    @Autowired
    IProductRepository iProductRepo;

    @GetMapping
    public String ListPage(Model model, @RequestParam(value = "page", defaultValue = "0") Integer page) {
        Page<Order> orderList = iOrderSer.findAll(PageRequest.of(page, 2));
        model.addAttribute("orderList", orderList);
        return "home_order";
    }

//    @GetMapping("/edit_parameter")
//    public String showEditParam(@RequestParam(name = "id") Integer id, Model model) {
//        model.addAttribute("order", iOrderSer.findById(id));
//        model.addAttribute("productList", iProductRepo.findAll());
//        return "edit_order";
//    }
//
//    @PostMapping("/edit")
//    public String edit(@Valid @ModelAttribute("order") Order order, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
//        new Order().validate(order, bindingResult);
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("order", order);
//            model.addAttribute("orderList", iProductRepo.findAll());
//            return "edit_order";
//        }
//        iOrderSer.save(order);
//        redirectAttributes.addFlashAttribute("message", "Edit Complete !");
//        return "redirect:/order";
//    }
}

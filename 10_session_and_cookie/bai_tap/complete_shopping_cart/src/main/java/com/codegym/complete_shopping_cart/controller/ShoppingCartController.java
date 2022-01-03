package com.codegym.complete_shopping_cart.controller;

import com.codegym.complete_shopping_cart.model.Cart;
import com.codegym.complete_shopping_cart.model.Product;
import com.codegym.complete_shopping_cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Optional;

@Controller
public class ShoppingCartController {
    @Autowired
    IProductService iProductService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart(@SessionAttribute("cart") Cart cart) {
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("cart", cart);
        return modelAndView;
    }

    @GetMapping("/view")
    public String view(@RequestParam("id") long id, Model model) {
        Optional<Product> product = iProductService.findById(id);
        model.addAttribute("product", product);
        return "view";
    }

    @GetMapping("/pay")
    public String payment(@SessionAttribute("cart") Cart cart, Model model) {
        model.addAttribute("cart", cart);
        return "pay";
    }

    @PostMapping("/pay")
    public String pay(@SessionAttribute("cart") Cart cart, Model model, RedirectAttributes redirectAttributes) {
        cart.setProducts(new HashMap<>());
        return "redirect:/shop";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id, @SessionAttribute("cart") Cart cart, RedirectAttributes redirectAttributes) {
        Product prodctOption = iProductService.findId(id);
        cart.deleteProduct(prodctOption);
        redirectAttributes.addFlashAttribute("message", "Delete product complete !");
        return "redirect:/shopping-cart";
    }
}

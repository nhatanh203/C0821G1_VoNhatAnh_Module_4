package com.codegym.controller;


import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    @Autowired
    IProductService iProductSer;

    @GetMapping("/")
    public String goView(Model model) {
        model.addAttribute("productList", iProductSer.findAll());
        return "view";
    }

    @GetMapping("create")
    public String goCreate(Model model) {
        model.addAttribute("productCreate", new Product());
        return "create";
    }

    @PostMapping("create")
    public String createProduct(@ModelAttribute(name = "productCreate") Product product, Model model) {
        iProductSer.save(product);
        model.addAttribute("productList", iProductSer.findAll());
        return "view";
    }

//    @GetMapping("delete")
//    public String deleteProduct(@RequestParam(name = "idDelete") int idDelete, Model model) {
//        iProductSer.delete(idDelete);
//        model.addAttribute("productList", iProductSer.findAll());
//        return "view";
//    }

    @GetMapping("edit")
    public String goEdit(@RequestParam(name = "idEdit") int idEdit, Model model) {
        model.addAttribute("productEdit", iProductSer.findById(idEdit));
        return "edit";
    }

    @PostMapping("edit")
    public String editProduct(@RequestParam(name = "id") int idEdit, @RequestParam(name = "name") String nameEdit, @RequestParam(name = "price") int priceEdit, Model model) {
        iProductSer.editById(idEdit, nameEdit, priceEdit);
        model.addAttribute("productList", iProductSer.findAll());
        return "view";
    }
}

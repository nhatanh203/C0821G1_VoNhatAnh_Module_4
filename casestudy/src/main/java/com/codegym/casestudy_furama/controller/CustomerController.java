package com.codegym.casestudy_furama.controller;

import com.codegym.casestudy_furama.model.customer.Customer;
import com.codegym.casestudy_furama.repository.customer.ICustomerTypeRepository;
import com.codegym.casestudy_furama.service.customer.ICustomerService;
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
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerService iCustomerSer;

    @Autowired
    ICustomerTypeRepository iCustomerTypeRepo;

    @GetMapping
    public String ListPage(Model model, @RequestParam(value = "page", defaultValue = "0") Integer page) {
        Page<Customer> customerList = iCustomerSer.findAll(PageRequest.of(page, 3));
        model.addAttribute("customerList", customerList);
        return "customer/home_customer";
    }

    @GetMapping("/create")
    public String create(Model model) {
        String[] gender = {"Male", "Female"};
        model.addAttribute("customer", new Customer());
        model.addAttribute("genderList", gender);
        model.addAttribute("customerTypeList", iCustomerTypeRepo.findAll());
        return "customer/create_customer";
    }


    @GetMapping("{id}/view")
    public String view(@PathVariable("id") Integer id, Model model) {
        Customer customer = iCustomerSer.findById(id);
        model.addAttribute("customer", customer);
        return "customer/view_customer";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("customer") Customer customer,
                       BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        new Customer().validate(customer, bindingResult);
        if (bindingResult.hasErrors()) {
            String[] gender = {"Male", "Female"};
            model.addAttribute("genderList", gender);
            model.addAttribute("customerTypeList", iCustomerTypeRepo.findAll());
            return "customer/create_customer";
        }
        redirectAttributes.addFlashAttribute("message", "Create Complete !");
        iCustomerSer.save(customer);
        return "redirect:/customer";
    }

    @GetMapping("/edit_parameter")
    public String showEditParam(@RequestParam(name = "id") Integer id, Model model) {
        model.addAttribute("customer", iCustomerSer.findById(id));
        model.addAttribute("customerTypeList", iCustomerTypeRepo.findAll());
        String[] gender = {"Male", "Female"};
        model.addAttribute("genderList", gender);
        return "customer/edit_customer";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model,
                       RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customer", customer);
            model.addAttribute("customerTypeList", iCustomerTypeRepo.findAll());
            String[] gender = {"Male", "Female"};
            model.addAttribute("genderList", gender);
            return "customer/edit_customer";
        }
        iCustomerSer.save(customer);
        redirectAttributes.addFlashAttribute("message", "Edit Complete !");
        return "redirect:/customer";
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "search") String name, Model model) {
        List<Customer> customer = iCustomerSer.findByName(name);
        model.addAttribute("customerList", customer);
        return "customer/search_customer";
    }

//    @GetMapping("{id}/delete")
//    public String showDelete(@PathVariable(name = "id") Integer id, Model model) {
//        model.addAttribute("customer", iCustomerSer.findById(id));
//        return "redirect:/customer";
//    }

    @GetMapping("/delete")
    public String deleteBlog(@RequestParam("id") Integer id){
        iCustomerSer.remove(id);
        return "redirect:/customer";
    }

//    @PostMapping("/delete")
//    public String delete(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
//        iCustomerSer.remove(customer.getId());
//        redirectAttributes.addFlashAttribute("message", "Delete Complete !");
//        return "redirect:/customer";
//    }
}

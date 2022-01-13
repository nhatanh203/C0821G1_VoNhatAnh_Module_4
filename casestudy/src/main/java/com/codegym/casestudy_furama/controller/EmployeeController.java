package com.codegym.casestudy_furama.controller;

import com.codegym.casestudy_furama.model.customer.Customer;
import com.codegym.casestudy_furama.model.employee.Employee;
import com.codegym.casestudy_furama.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService iEmployeeSer;

    @GetMapping
    public String ListPage(Model model) {
        List<Employee> employee = iEmployeeSer.getAll();
        model.addAttribute("employeeList", employee);
        return "employee/home_employee";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee/create_employee";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("employee") Employee employee, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "Create Complete !");
        iEmployeeSer.save(employee);
        return "redirect:/employee";
    }

//    @GetMapping("{id}/delete")
//    public String showDelete(@PathVariable(name = "id") Integer id, Model model) {
//        model.addAttribute("employee", iEmployeeSer.findById(id));
//        return "employee/delete_employee";
//    }
//
//    @PostMapping("/delete")
//    public String delete(@ModelAttribute("employee") Employee employee, RedirectAttributes redirectAttributes) {
//        iEmployeeSer.remove(employee.getId());
//        redirectAttributes.addFlashAttribute("message", "Delete Complete!");
//        return "redirect:/employee";
//    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id){
        iEmployeeSer.remove(id);
        return "redirect:/employee";
    }

    @GetMapping("/edit_param")
    public String showEditParam(@RequestParam(name = "id") Integer id, Model model) {
        model.addAttribute("employee", iEmployeeSer.findById(id));
        return "employee/edit_employee";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute("employee") Employee employee,RedirectAttributes redirectAttributes) {
        iEmployeeSer.save(employee);
        redirectAttributes.addFlashAttribute("message", "Edit Complete !");
        return "redirect:/employee";
    }

    @GetMapping("{id}/view")
    public String view(@PathVariable("id") Integer id, Model model) {
        Employee employee = iEmployeeSer.findById(id);
        model.addAttribute("employee", employee);
        return "employee/view_employee";
    }
}

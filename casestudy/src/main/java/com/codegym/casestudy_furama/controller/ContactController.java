package com.codegym.casestudy_furama.controller;

import com.codegym.casestudy_furama.model.contract.Contract;
import com.codegym.casestudy_furama.model.service.Services;
import com.codegym.casestudy_furama.service.contract.IAttachServiceService;
import com.codegym.casestudy_furama.service.contract.IContractDetailService;
import com.codegym.casestudy_furama.service.contract.IContractService;
import com.codegym.casestudy_furama.service.customer.ICustomerService;
import com.codegym.casestudy_furama.service.employee.IEmployeeService;
import com.codegym.casestudy_furama.service.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContactController {
    @Autowired
    private IContractService iContractSer;

    @Autowired
    private IContractDetailService iContractDetailSer;

    @Autowired
    private IAttachServiceService iAttachServiceSer;

    @Autowired
    private ICustomerService iCustomerSer;

    @Autowired
    private IEmployeeService iEmployeeSer;

    @Autowired
    private IServiceService iServiceSer;

    @GetMapping
    public String ListPage(Model model){
        List<Contract> contract = iContractSer.getAll();
        model.addAttribute("contractList", contract);
        return "contract/home_contract";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("contract", new Contract());
        model.addAttribute("customerList",iCustomerSer.getAll());
        model.addAttribute("employeeList",iEmployeeSer.getAll());
        model.addAttribute("servicesList",iServiceSer.getAll());

        return "contract/create_contract";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("contract") Contract contract,
                       BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        new Contract().validate(contract,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("customerList",iCustomerSer.getAll());
            model.addAttribute("employeeList",iEmployeeSer.getAll());
            model.addAttribute("servicesList",iServiceSer.getAll());
            return "contract/create_contract";

        }
        redirectAttributes.addFlashAttribute("message", "Create success");
        iContractSer.save(contract);
        return "redirect:/contract";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id){
        iContractSer.remove(id);
        return "redirect:/contract";
    }

    @GetMapping("/edit_param")
    public String showEditParam(@RequestParam(name = "id") Integer id, Model model) {
        model.addAttribute("contract", iContractSer.findById(id));
        model.addAttribute("customerList",iCustomerSer.getAll());
        model.addAttribute("employeeList",iEmployeeSer.getAll());
        model.addAttribute("servicesList",iServiceSer.getAll());
        return "contract/edit_contract";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("contract") Contract contract,BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()){
            model.addAttribute("customerList",iCustomerSer.getAll());
            model.addAttribute("employeeList",iEmployeeSer.getAll());
            model.addAttribute("servicesList",iServiceSer.getAll());
            return "contract/edit_contract";

        }
        iContractSer.save(contract);
        redirectAttributes.addFlashAttribute("message", "Edit success");
        return "redirect:/contract";
    }

    @GetMapping("{id}/view")
    public String view(@PathVariable("id") Integer id, Model model) {
        Contract contract = iContractSer.findById(id);
        model.addAttribute("contract", contract);
        return "contract/view_contract";
    }


}

package com.codegym.casestudy_furama.controller;

import com.codegym.casestudy_furama.model.service.Services;
import com.codegym.casestudy_furama.service.service.IServiceService;
import com.codegym.casestudy_furama.service.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    IServiceService iServiceSer;

    @Autowired
    IServiceTypeService iServiceTypeSer;

    @GetMapping
    public String ListPage(Model model){
        List<Services> service = iServiceSer.getAll();
        model.addAttribute("serviceList", service);
        return "service/home_service";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("service", new Services());
        model.addAttribute("serviceTypeList",iServiceTypeSer.getAll());
        return "service/create_service";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("service") Services service,
                       BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        new Services().validate(service,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("serviceTypeList",iServiceTypeSer.getAll());
            return "service/create_service";
        }
        redirectAttributes.addFlashAttribute("message", "Create Complete !");
        iServiceSer.save(service);
        return "redirect:/service";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id){
        iServiceSer.remove(id);
        return "redirect:/service";
    }

    @GetMapping("/edit_param")
    public String showEditParam(@RequestParam(name = "id") Integer id, Model model) {
        model.addAttribute("service", iServiceSer.findById(id));
        model.addAttribute("serviceTypeList",iServiceTypeSer.getAll());
        return "service/edit_service";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute("service") Services service,BindingResult bindingResult,
                       Model model, RedirectAttributes redirectAttributes) {
        new Services().validate(service,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("serviceTypeList",iServiceTypeSer.getAll());
            return "service/create_service";
        }
        iServiceSer.save(service);
        redirectAttributes.addFlashAttribute("message", "Edit Complete !");
        return "redirect:/service";
    }

    @GetMapping("{id}/view")
    public String view(@PathVariable("id") Integer id, Model model) {
        Services service = iServiceSer.findById(id);
        model.addAttribute("service", service);
        return "service/view_service";
    }

}

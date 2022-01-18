package com.example.baithi.controller;

import com.example.baithi.model.SanPham;
import com.example.baithi.service.ISanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SanPhamController {
    @Autowired
    private ISanPhamService sanPhamService;
//    @GetMapping("")
//    public String getPageList(Model model) {
//        model.addAttribute("listsanpham", sanPhamService.showList());
//        return "list";
//    }
    @GetMapping(value = "/edit")
    public String getPageEdit(@RequestParam(name="idEdit")int idEdit,Model model){
        model.addAttribute("sanpham",sanPhamService.findSanPhamById(idEdit));
        return "edit";
    }
    @GetMapping("")
    public String listEmployee(Model model, @RequestParam(value = "page", defaultValue = "0")int page){
        Sort sort = Sort.by("maSp").ascending();
        Page<SanPham> sanPhamPage = sanPhamService.findAll(PageRequest.of(page,3,sort));
        model.addAttribute("sanPhamPage", sanPhamPage);
        return "/list";
    }
}

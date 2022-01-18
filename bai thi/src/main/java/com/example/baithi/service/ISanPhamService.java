package com.example.baithi.service;

import com.example.baithi.model.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ISanPhamService {
    public List<SanPham> showList();
    public SanPham findSanPhamById(int id);
    Page<SanPham> findAll(PageRequest of);
}

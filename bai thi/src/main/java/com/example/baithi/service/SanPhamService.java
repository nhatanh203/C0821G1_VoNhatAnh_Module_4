package com.example.baithi.service;

import com.example.baithi.model.SanPham;
import com.example.baithi.repository.ISanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanPhamService implements ISanPhamService {
    @Autowired
    private ISanPhamRepository iSanPhamRepository;
    @Override
    public List<SanPham> showList() {
        return iSanPhamRepository.findAll();
    }

    @Override
    public SanPham findSanPhamById(int id) {
            SanPham sanPham=iSanPhamRepository.getById(id);
            return sanPham;

    }

    @Override
    public Page<SanPham> findAll(PageRequest of) {
            return iSanPhamRepository.findAll(of);
    }

}

package com.example.baithi.repository;

import com.example.baithi.model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISanPhamRepository extends JpaRepository<SanPham,Integer> {
}

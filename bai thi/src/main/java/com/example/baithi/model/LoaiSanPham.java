package com.example.baithi.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "loai_san_pham")
public class LoaiSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_loai_sp")
    private int maLoaiSp;
    @Column(name = "ten_loai_sp")
    private String tenLoaiSp;

    @OneToMany(mappedBy = "loaiSanPham")
    private Set<SanPham> sanPhams;

    public Set<SanPham> getSanPhams() {
        return sanPhams;
    }

    public void setSanPhams(Set<SanPham> sanPhams) {
        this.sanPhams = sanPhams;
    }

    public LoaiSanPham() {
    }

    public LoaiSanPham(int maLoaiSp, String tenLoaiSp) {
        this.maLoaiSp = maLoaiSp;
        this.tenLoaiSp = tenLoaiSp;
    }

    public int getMaLoaiSp() {
        return maLoaiSp;
    }

    public void setMaLoaiSp(int maLoaiSp) {
        this.maLoaiSp = maLoaiSp;
    }

    public String getTenLoaiSp() {
        return tenLoaiSp;
    }

    public void setTenLoaiSp(String tenLoaiSp) {
        this.tenLoaiSp = tenLoaiSp;
    }
}

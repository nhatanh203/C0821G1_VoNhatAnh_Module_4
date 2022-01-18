package com.example.baithi.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "don_hang")
public class DonHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_don_hang")
    private int maDH;
    @Column(name = "ngay_mua")
    private String ngayMua;
    @Column(name="so_luong")
    private int soLuong;
    @Column(name = "ma_sp")
    private int maSp;

    @OneToMany(mappedBy = "donHang")
    private Set<SanPham> sanPhams;

    public Set<SanPham> getSanPhams() {
        return sanPhams;
    }

    public void setSanPhams(Set<SanPham> sanPhams) {
        this.sanPhams = sanPhams;
    }

    public DonHang() {
    }

    public DonHang(int maDH, String ngayMua, int soLuong, int maSp) {
        this.maDH = maDH;
        this.ngayMua = ngayMua;
        this.soLuong = soLuong;
        this.maSp = maSp;
    }

    public int getMaDH() {
        return maDH;
    }

    public void setMaDH(int maDH) {
        this.maDH = maDH;
    }

    public String getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(String ngayMua) {
        this.ngayMua = ngayMua;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getMaSp() {
        return maSp;
    }

    public void setMaSp(int maSp) {
        this.maSp = maSp;
    }
}

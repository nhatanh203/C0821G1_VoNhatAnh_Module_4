package com.example.baithi.model;

import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import javax.persistence.*;

@Entity
@Table(name = "san_pham")
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_sp")
    private int maSp;
    @Column(name = "ten_sp")
    private String tenSp;
    @Column(name="gia_sp")
    private double giaSp;
    @Column(name="tinh_trang_sp")
    private String tinhTrangSp;


    @ManyToOne
    @JoinColumn(name = "ma_loai_sp")
    private LoaiSanPham loaiSanPham;

    @ManyToOne
    @JoinColumn(name="ma_don_hang")
    private DonHang donHang;

    public DonHang getDonHang() {
        return donHang;
    }

    public void setDonHang(DonHang donHang) {
        this.donHang = donHang;
    }

    public LoaiSanPham getLoaiSanPham() {
        return loaiSanPham;
    }

    public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }

    public SanPham() {
    }

    public SanPham(int maSp, String tenSp, double giaSp, String tinhTrangSp) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.giaSp = giaSp;
        this.tinhTrangSp = tinhTrangSp;

    }

    public int getMaSp() {
        return maSp;
    }

    public void setMaSp(int maSp) {
        this.maSp = maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public double getGiaSp() {
        return giaSp;
    }

    public void setGiaSp(double giaSp) {
        this.giaSp = giaSp;
    }

    public String getTinhTrangSp() {
        return tinhTrangSp;
    }

    public void setTinhTrangSp(String tinhTrangSp) {
        this.tinhTrangSp = tinhTrangSp;
    }


}

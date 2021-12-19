package com.codegym.controller;

import com.codegym.model.Medical;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MedicalController {
    @GetMapping("/medical")
    public String medicalForm(Model model) {
        String[] gioiTinh = {"Nam", "Nữ"};
        String[] thongTinDiLai = {"Máy Bay", "Tàu Thuyền", "Ô Tô", "Khác"};
        String[] trieuChung = {"Sốt", "Ho", "Khó thở", "Đau họng", "Nôn/Buồn Nôn", "Tiêu chảy", "Xuất huyết ngoài da", "Nổi ban ngoài da", "Không"};
        String[] lichSuPhoiNhiem = {"Đến trang trại chăn nuôi/Tiếp xúc động vật", "Tiếp xúc gần (<2m) với người mắc bệnh viêm đường hô hấp do nCoV", "Không"};
        model.addAttribute("gioiTinh", gioiTinh);
        model.addAttribute("thongTinDiLai", thongTinDiLai);
        model.addAttribute("trieuChung", trieuChung);
        model.addAttribute("lichSuPhoiNhiem", lichSuPhoiNhiem);


        model.addAttribute("medical", new Medical());
        return "medical";
    }

    @PostMapping("/medical_form")
    public String updateMedicalDeclaration(@ModelAttribute("medical") Medical medical, Model model){

        model.addAttribute("hoTen", medical.getHoTen());
        model.addAttribute("namSinh", medical.getNamSinh());
        model.addAttribute("gioiTinh", medical.getGioiTinh());
        model.addAttribute("quocTich", medical.getQuocTich());
        model.addAttribute("cmnd", medical.getCmnd());
        model.addAttribute("bienSoXe", medical.getBienSo());
        model.addAttribute("thongTinDiLai", medical.getThongTinDilai());
        model.addAttribute("soGhe", medical.getSoGhe());
        model.addAttribute("ngayKhoiHanh", medical.getNgayKhoiHanh());
        model.addAttribute("ngayKetThuc", medical.getNgayKetThuc());
        model.addAttribute("moTa", medical.getMoTa());
        model.addAttribute("diaChiLienLac", medical.getDiaChiLienLac());
        model.addAttribute("diaChiNoiO", medical.getDiaChiNoiO());
        model.addAttribute("soDienThoai", medical.getSoDienThoai());
        model.addAttribute("email", medical.getEmail());
        model.addAttribute("trieuChung", medical.getTrieuChung());
        model.addAttribute("lichSuPhoiNhiem", medical.getLichSuPhoiNhiem());
        return "medical_form";
    }
}

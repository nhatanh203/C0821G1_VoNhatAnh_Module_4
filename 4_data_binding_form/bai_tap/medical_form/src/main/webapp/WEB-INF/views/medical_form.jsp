<%--
  Created by IntelliJ IDEA.
  User: vonhatanh
  Date: 19/12/2021
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3 style="text-align: center;color:#b94f4f">Tờ khai y tế</h3>
<center>
    <p>Họ tên : <c:out value="${medical.hoTen}"/></p>
    <p>Năm sinh : <c:out value="${medical.namSinh}"/></p>
    <p>Giới tính : <c:out value="${medical.gioiTinh}"/></p>
    <p>Quốc tịch : <c:out value="${medical.quocTich}"/></p>
    <p>Số CMND : <c:out value="${medical.cmnd}"/></p>
    <p>Thông tin đi lại : <c:out value="${medical.thongTinDilai}"/></p>
    <p>Biển số xe : <c:out value="${medical.bienSo}"/></p>
    <p>Số ghế : <c:out value="${medical.soGhe}"/></p>
    <p>Ngày khởi hành : <c:out value="${medical.ngayKhoiHanh}"/></p>
    <p>Ngày kết thúc : <c:out value="${medical.ngayKetThuc}"/></p>
    <p>Mô tả thêm : <c:out value="${medical.moTa}"/></p>
    <p>Địa chỉ liên lạc : <c:out value="${medical.diaChiLienLac}"/></p>
    <p>Địa chỉ nơi ở : <c:out value="${medical.diaChiNoiO}"/></p>
    <p>Số điện thoại : <c:out value="${medical.soDienThoai}"/></p>
    <p>Email : <c:out value="${medical.email}"/></p>
    <p>Triệu Chứng : <c:out value="${medical.trieuChung}"/></p>
    <p>Lịch sử phơi nhiễm : <c:out value="${medical.lichSuPhoiNhiem}"/></p>
</center>
</body>
</html>

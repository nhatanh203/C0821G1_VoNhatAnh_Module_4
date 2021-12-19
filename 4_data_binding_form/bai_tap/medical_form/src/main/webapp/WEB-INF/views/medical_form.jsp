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
    <p>Họ tên : <c:out value="${hoTen}"/></p>
    <p>Năm sinh : <c:out value="${namSinh}"/></p>
    <p>Giới tính : <c:out value="${gioiTinh}"/></p>
    <p>Quốc tịch : <c:out value="${quocTich}"/></p>
    <p>Số CMND : <c:out value="${cmnd}"/></p>
    <p>Thông tin đi lại : <c:out value="${thongTinDiLai}"/></p>
    <p>Biển số xe : <c:out value="${bienSoXe}"/></p>
    <p>Số ghế : <c:out value="${soGhe}"/></p>
    <p>Ngày khởi hành : <c:out value="${ngayKhoiHanh}"/></p>
    <p>Ngày kết thúc : <c:out value="${ngayKetThuc}"/></p>
    <p>Mô tả thêm : <c:out value="${moTa}"/></p>
    <p>Địa chỉ liên lạc : <c:out value="${diaChiLienLac}"/></p>
    <p>Địa chỉ nơi ở : <c:out value="${diaChiNoiO}"/></p>
    <p>Số điện thoại : <c:out value="${soDienThoai}"/></p>
    <p>Email : <c:out value="${email}"/></p>
    <p>Triệu Chứng : <c:out value="${trieuChung}"/></p>
    <p>Lịch sử phơi nhiễm : <c:out value="${lichSuPhoiNhiem}"/></p>
</center>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: vonhatanh
  Date: 19/12/2021
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Tờ Khai Y Tế</title>
</head>
<body>
<h2 style="text-align:center">Tờ Khai Y Tế</h2>
<h4 style="text-align:center">ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP
    CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</h4>
<p style="color:red;text-align:center"><strong>Khuyến cáo : Khai báo thông tin sai là vi phạm pháp luật Việt Nam
    và có thể xử lí hình sự</strong></p>
<form:form action="medical_form" method="post" modelAttribute="medical">
<table border="1">
    <tr>
        <td>
            Họ Tên (Ghi chữ in hoa) :
        </td>
        <td>
            <form:input type="text" path="hoTen"/>
        </td>
    </tr>
    <tr>
        <td>
            Năm sinh :
        </td>
        <td>
            <form:input type="number" path="namSinh"/>
        </td>
    </tr>
    <tr>
        <td>
            Giới tính :
        </td>
        <td>
            <form:select path="gioiTinh">
                <form:options items="${gioiTinh}"/>;
            </form:select>
        </td>
    </tr>
    <tr>
        <td>
            Quốc tịch :
        </td>
        <td>
            <form:input type="text" path="quocTich"/>
        </td>
    </tr>
    <tr>
        <td>
            Số hộ chiếu hoặc số CMND :
        </td>
        <td>
            <form:input type="number" path="cmnd"/>
        </td>
    </tr>
    <tr>
        <td>
            Số hiệu phương tiện :
        </td>
        <td>
            <form:input type="number" path="bienSo"/>
        </td>
    </tr>
    <tr>
        <td>
            Thông tin đi lại :
        </td>
        <td>
            <form:select path="thongTinDilai">
                <form:options items="${thongTinDiLai}"/>;
            </form:select>
        </td>
    </tr>
    <tr>
        <td>
            Số ghế :
        </td>
        <td>
            <form:input type="number" path="soGhe"/>
        </td>
    </tr>
    <tr>
        <td>
            Ngày khởi hành :
        </td>
        <td>
            <form:input type="date" path="ngayKhoiHanh"/>
        </td>
    </tr>
    <tr>
        <td>
            Ngày kết thúc :
        </td>
        <td>
            <form:input type="date" path="ngayKetThuc"/>
        </td>
    </tr>

    <tr>

        <td>
            Trong vòng 14 ngày qua Anh/Chị đến những tỉnh thành phố nào ? :
        </td>
        <td>
            <form:textarea path="moTa"/>
        </td>
    </tr>
    <tr>
        <td>
            <strong>Địa chỉ liên lạc</strong>
        </td>
        <td>
            <form:input type="text" path="diaChiLienLac"/>
        </td>
    </tr>
    <tr>
        <td>
            Địa chỉ nơi ở:
        </td>
        <td>
            <form:input type="text" path="diaChiNoiO"/>
        </td>
    </tr>
    <tr>
        <td>
            Điện thoại :
        </td>
        <td>
            <form:input type="text" path="soDienThoai"/>
        </td>
    </tr>
    <tr>
        <td>
            Email :
        </td>
        <td>
            <form:input type="text" path="email"/>
        </td>
    </tr>
    <tr>
        <td>
            <strong>Trong vòng 14 ngày vừa qua, Anh/Chị có xuất hiện triệu chứng nào sau đây không ?
                : </strong>
        </td>
        <td>
            <form:checkboxes path="trieuChung" items="${trieuChung}"/>
        </td>
    </tr>
    <tr>
        <td>
            Lịch sử phơi nhiễm: Trong vòng 14 ngày vừa qua, Anh/Chị có :
        </td>
        <td>
            <form:checkboxes path="lichSuPhoiNhiem" items="${lichSuPhoiNhiem}"/>
        </td>
    </tr>
</table>
<p style="color: red;text-align:center"> Dữ liệu bạn cung cấp hoàn toàn bảo mật và chỉ phục vụ cho việc
    phòng chống dịch, thuộc quản lý của ban
    chỉ đạo quốc gia về Phòng chống dịch covid 19. Khi bạn nhấn nút "Gửi" là bạn đã hiểu và đồng ý.</p>
<p style="text-align: center"><form:button>GỬI TỜ KHAI</form:button></p>
</form:form>
</body>
</html>

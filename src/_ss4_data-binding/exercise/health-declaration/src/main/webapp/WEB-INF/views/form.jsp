<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 6/16/2022
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>To Khai Y Te</title>
    <link rel="stylesheet" href="/resources/bootstrap/bootstrap/css/bootstrap.min.css">
</head>
<body>
<div class="container-fluid px-3 py-3">
    <h5 class="text-center"> TỜ KHAI Y TẾ </h5>
    <h6 class="text-center"> ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG DỊCH BỆNH
        TRUYỀN NHIỄM </h6>
    <P class=" text-center text-danger"> Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể bị xử lý hình sự</P>
    <form:form action="save" method="post" modelAttribute="healthDeclaration">
    <div>
        <div class="form-group">
            <label>Họ tên(IN HOA)</label> <span class="text-danger font-italic">(*)</span>
            <form:input cssClass="form-control" path="name" value="${healthDeclaration.name}"/>
        </div>
        <div class="form-row">
            <div class="form-group col-md-4">
                <label>Năm sinh </label> <span class="text-danger font-italic">(*)</span>
                <form:select path="yearOfBirth" items="${years}" cssClass="form-control" value="${healthDeclaration.yearOfBirth}">
                </form:select>
            </div>
            <div class="form-group col-md-4">
                <label>Giới tính </label> <span class="text-danger font-italic">(*)</span>
                <form:select path="gender" items="${genders}" cssClass="form-control" value="${healthDeclaration.gender}">
                </form:select>
            </div>
            <div class="form-group col-md-4">
                <label>Quốc tịch </label> <span class="text-danger font-italic">(*)</span>
                <form:select path="nationality" items="${nations}" cssClass="form-control" value="${healthDeclaration.nationality}">
                </form:select>
            </div>
        </div>
        <div class="form-group">
            <label>Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác</label> <span class="text-danger font-italic">(*)</span>
            <form:input cssClass="form-control" path="idCard" value="${healthDeclaration.idCard}"/>
        </div>
        <div class="form-group">
            <label>Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác</label> <span class="text-danger font-italic">(*)</span>
            <div class="form-row d-flex justify-content-around">
                <form:radiobuttons items="${vehicles}" path="vehicle" value="${healthDeclaration.vehicle}"/>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label>Số hiệu phương tiện </label>
                <form:input path="vehicleNumber" cssClass="form-control" value="${healthDeclaration.vehicleNumber}"/>
            </div>
            <div class="form-group col-md-6">
                <label>Số ghế </label>
                <form:input path="seatNumber" cssClass="form-control" value="${healthDeclaration.seatNumber}"/>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label>Ngày khởi hành </label><span class="text-danger font-italic">(*)</span>
                <form:input type="date" path="startDate" cssClass="form-control" value="${healthDeclaration.startDate}"/>
            </div>
            <div class="form-group col-md-6">
                <label>Ngày kết thúc</label><span class="text-danger font-italic">(*)</span>
                <form:input type="date" path="endDate" cssClass="form-control" value="${healthDeclaration.endDate}"/>
            </div>
        </div>
        <div class="form-group">
            <label>Trong vòng 14 ngày qua, Anh/Chị có đến Tỉnh/Thành phố nào?</label> <span class="text-danger font-italic">(*)</span>
            <form:textarea class="form-control" path="city" rows="3" value="${healthDeclaration.city}"></form:textarea>
        </div>
        <input type="submit" class="btn btn-success mb-2" value="Gửi tờ khai">
    </div>
</div>
</form:form>
</div>
</body>
</html>
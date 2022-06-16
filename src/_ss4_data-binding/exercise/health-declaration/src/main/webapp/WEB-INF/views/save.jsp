<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 6/16/2022
  Time: 6:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>THÔNG TIN TỜ KHAI</title>
</head>
<body>
<h2>THÔNG TIN TỜ KHAI</h2>
Họ và tên: ${healthDeclaration.name} <br>
Năm sinh: ${healthDeclaration.yearOfBirth} <br>
Giới tính: ${healthDeclaration.gender} <br>
Quốc tịch:${healthDeclaration.nationality}<br>
Số CMND: ${healthDeclaration.idCard}<br>
Di chuyển bằng:${healthDeclaration.vehicle}<br>
Số phương tiện: ${healthDeclaration.vehicleNumber}<br>
Số ghế: ${healthDeclaration.seatNumber}<br>
Ngày khởi hành: ${healthDeclaration.startDate}<br>
Ngày kết thúc: ${healthDeclaration.endDate}<br>
Thành phố đã đến: ${healthDeclaration.city}<br>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: fzaca
  Date: 2025-06-04
  Time: 오후 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <style>
    ol{display: flex}
    li{margin-right: 20px;}
  </style>
</head>
<body>
<h2>예약 스텝 2: 객실 선택</h2>
<ol>
  <li>호텔 및 일정 선택 </li>
  <li>객실 선택 </li>
  <li style="color: green">옵션</li>
  <li>예약정보 입력</li>
</ol>
<div>
  <%--  hotelId=1&checkIn=2025-06-04&checkOut=2025-06-05--%>
  <p style="color: gray">📝사용자 정보📝</p>
  <p style="color: gray">호텔ID : ${param.hotelId}</p>
  <p style="color: gray">체크인 : ${param.checkIn}</p>
  <p style="color: gray">체크아웃 : ${param.checkOut}</p>
  <p style="color: gray">객실선택 : ${roomType}</p>
</div>
<form action="rsvStep3" method="get">
  <p>옵션을 선택해주세요 </p>

</form>
</body>
</html>

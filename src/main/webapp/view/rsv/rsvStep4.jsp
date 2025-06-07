<%--
  Created by IntelliJ IDEA.
  User: fzaca
  Date: 2025-06-04
  Time: 오후 11:47
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
<h2>예약 스텝 4: 예약자 정보 입력</h2>
<ol>
  <li>호텔 및 일정 선택 </li>
  <li>객실 선택 </li>
  <li>옵션</li>
  <li style="color: green">예약정보 입력</li>
</ol>
<div>
  <%--  hotelId=1&checkIn=2025-06-04&checkOut=2025-06-05--%>
  <p style="color: gray">📝사용자 정보📝</p>
  <p style="color: gray">호텔ID : ${param.hotelId}</p>
  <p style="color: gray">체크인 : ${param.checkIn}</p>
  <p style="color: gray">체크아웃 : ${param.checkOut}</p>
  <p style="color: gray">객실선택 : ${param.roomType}</p>
  <p style="color: gray">추가옵션 : ${param}</p><br>

</div>
<form action="reserveSubmit" method="post">
  <input type="hidden" name="hotelId" value="${param.hotelId}">
  <input type="hidden" name="checkIn" value="${param.checkIn}">
  <input type="hidden" name="checkOut" value="${param.checkOut}">
  <input type="hidden" name="roomType" value="${param.roomType}">
  <p>👇예약자 정보를 입력해주세요👇</p><br>
  ✒️예약자 정보 <input type="text" name="reserverName"><br>
  ✒️요청사항 <textarea name="reqDetail" id="reqDetail" cols="30" rows="10"></textarea><br>
  ✒️약관동의 <input type="checkbox" name="term">
  <button type="submit">예약완료</button>
</form>
</body>
</html>

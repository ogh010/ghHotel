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
<h2>예약 스텝 3: 옵션 선택</h2>
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
    <p style="color: gray">어른 수  : ${param.adultCount}</p>
    <p style="color: gray">아이 수 : ${param.childCount}</p>
    <p style="color: gray">총 금액 : ${totalAmount}</p>
    <p style="color: gray">객실선택 : ${roomType}</p>
</div>
<form action="rsvStep3" method="get">
  <input type="hidden" name="hotelId" value="${param.hotelId}">
  <input type="hidden" name="checkIn" value="${param.checkIn}">
  <input type="hidden" name="checkOut" value="${param.checkOut}">
  <input type="hidden" name="adultCount" value="${param.adultCount}">
  <input type="hidden" name="childCount" value="${param.childCount}">
  <input type="hidden" name="totalAmount" value="${totalAmount}">
  <input type="hidden" name="roomType" value="${roomType}">
  <p>옵션을 선택해주세요 </p>
  <p>🛠️ 추가 옵션을 선택하세요 (선택사항)</p>
  <label>
    <input type="checkbox" name="option" value="upgrade"> 🔼 룸 업그레이드 (+30,000원)
  </label><br>
  <label>
    <input type="checkbox" name="option" value="breakfast"> 🍳 조식 포함 (+15,000원)
  </label><br>
  <label>
    <input type="checkbox" name="option" value="shuttle"> 🚌 공항 셔틀 (+20,000원)
  </label><br>
  <label>
    <input type="checkbox" name="option" value="lateCheckout"> 🕓 레이트 체크아웃 (+10,000원)
  </label><br>
  <label>
    <input type="checkbox" name="option" value="wine"> 🍷 와인 세트 제공 (+25,000원)
  </label><br><br>

  <button type="submit">다음 단계 → 예약자 정보 입력</button>
</form>
</body>
</html>

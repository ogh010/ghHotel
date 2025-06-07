<%--
  Created by IntelliJ IDEA.
  User: fzaca
  Date: 2025-06-04
  Time: 오전 1:36
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
  <li style="color: green">객실 선택 </li>
  <li>옵션</li>
  <li>예약정보 입력</li>
</ol>
<div>
<%--  hotelId=1&checkIn=2025-06-04&checkOut=2025-06-05--%>
  <p style="color: gray">📝사용자 정보📝</p>
  <p style="color: gray">호텔ID : ${hotelId}</p>
  <p style="color: gray">체크인 : ${checkIn}</p>
  <p style="color: gray">체크아웃 : ${checkOut}</p>
  <p style="color: gray">어른 수  : ${adultCount}</p>
  <p style="color: gray">아이 수 : ${childCount}</p>
  <p style="color: gray">총 금액 : ${totalAmount}</p>
</div>
<div>
  <form action="rsvStep2" method="get">
    <input type="hidden" name="hotelId" value="${hotelId}">
    <input type="hidden" name="checkIn" value="${checkIn}">
    <input type="hidden" name="checkOut" value="${checkOut}">
    <input type="hidden" name="adultCount" value="${adultCount}">
    <input type="hidden" name="childCount" value="${childCount}">
    <input type="hidden" name="totalAmount" value="${totalAmount}">
    <p>🛏️객실을 선택하세요🛏️</p>
    <input id="r1" type="radio" name="roomType" value="1">
    <label for="r1">싱글룸 👤</label>
    <br>
    <input id="r2" type="radio" name="roomType" value="2">
    <label for="r2">더블룸 🫂 (+10,000원)</label>
    <br>
    <input id="r3" type="radio" name="roomType" value="3">
    <label for="r3">트윈룸 👥 (+10,000원)</label>
    <br>
    <input id="r4" type="radio" name="roomType" value="4">
    <label for="r4">스튜디오룸 🎥 (+20,000원)</label>
    <br>
    <input id="r5" type="radio" name="roomType" value="5">
    <label for="r5">헐리우드룸 🎞️ (+30,000원)</label>
    <br>
    <button type="submit">확인 (다음 단계) →</button>
  </form>
</div>
</body>
</html>

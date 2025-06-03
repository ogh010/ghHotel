<%--
  Created by IntelliJ IDEA.
  User: fzaca
  Date: 2025-06-02
  Time: 오후 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>main</h1>
<%--<c:if test="${!empty sessionScope.loginUser}">${sessionScope.loginUser.username} 님 안녕하세요</c:if>--%>
<%--<c:if test="${empty sessionScope.loginUser}">로그인 해주세요</c:if>--%>
<p>${sessionScope.loginUser.username} 님 안녕하세요</p>
<form action="rsvStep1" method="get">
    <div>
        🔻 호텔 선택:
        <select name="hotelId" id="hotelSelect">
            <option value="">--호텔 선택--</option>
            <option value="1">서울호텔</option>
            <option value="2">부산호텔</option>
            <option value="3">제주호텔</option>
        </select>
    </div>
    <div>
        📅 체크인:
        <input type="date" name="checkIn">
        📅 체크아웃:
        <input type="date" name="checkOut">
    </div>
    <div>
        👨‍👩 인원 선택:<br>
        성인 :
        <input type="number" >
<%--        <button type="button" class="minus">-</button>--%>
<%--        <span class="counter" id="adultCount">1</span>--%>
<%--        <button type="button" class="plus">+</button>--%>
        어린이 :
        <input type="number" >
<%--        <button type="button" class="minusChild">-</button>--%>
<%--        <span class="counter" id="childCount">1</span>--%>
<%--        <button type="button" class="plusChild">+</button>--%>
    </div>
    <button type="submit" >검색 (다음 단계) →</button>
</form>
</body>
</html>

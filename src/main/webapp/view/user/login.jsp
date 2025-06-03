<%--
  Created by IntelliJ IDEA.
  User: fzaca
  Date: 2025-06-01
  Time: 오후 7:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<h1>login</h1>
<form action="login" method="post">
    아이디 <input type="text" class="username" name="username"> <br>
    비밀번호 <input type="text" class="password" name="password"> <br>
    <button type="submit" class="login">로그인</button>
</form>

<script>
    $(function (){
        $(".login").on("click",function (){
            console.log("로그인 버튼 클릭");
            // let username = $(".username").val();
            // let password = $(".password").val();
            // $.ajax({
            //     url:"login",
            //     method:"POST",
            //     data:{
            //         username:username,
            //         password:password
            //     },
            //     success:function (response){
            //         console.log(response);
            //     }
            // })
        })
    })
</script>
</body>
</html>
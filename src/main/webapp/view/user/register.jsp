<%--
  Created by IntelliJ IDEA.
  User: fzaca
  Date: 2025-06-01
  Time: 오후 8:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<%--    <script src="ghhotel2/resources/js/ajaxUtils.js"></script>--%>
</head>
<body>
    <h1>register 회원가입페이지</h1>
    <form action="register" method="post" id="registerForm">
        아이디 : <input type="text" name="username" id="username" class="username" > <br/>
        <button type="button" class="checkIdBtn">아이디중복체크</button>  <br/>
        비밀번호 : <input type="text" name="password" class="password"> <br/>
        비밀번호 확인 : <input type="text" name="checkPassword" class="checkPassword"> <br/>
        <p id="checkPwdMsg"></p>
        이름 : <input type="text" name="name" class="name"> <br/>
        이메일 : <input type="text" name="email" class="email"> <br/>
        전화번호 : <input type="text" name="phone" class="phone"> <br/>
        <button type="submit" class="submitBtn" disabled>회원가입</button>
        <p id="formError" style="color:red"></p>
        <p id="checkMsg"></p>
    </form>
    <script>
        $(function(){
            // 아이디 중복 체크 메서드
            $(".checkIdBtn").on("click",function(){
                console.log("아이디중복체크");
                let username = $("#username").val().trim(); // 입력창 값 얻기

                console.log(username);
                if(!username){
                    $('#checkMsg').css("color", "red").text("아이디를 입력하세요");
                    return; // 필수 ajax 요청 중단
                } else {
                    $("#checkMsg").text(""); // 메시지 초기화
                }

                $.ajax({
                    url:"checkuserid",
                    method:"POST",
                    data:{username:username},
                    dataType : 'text',
                    success: function (response) {
                        console.log(response)
                        if (response == 'true') {
                            alert("서버 응답: " + response);
                            $('#checkMsg').css("color", "red").text("이미 사용 중인 아이디입니다.");
                        } else {
                            alert("서버 응답: " + response);
                            $('#checkMsg').css("color", "green").text("사용 가능한 아이디입니다.");
                        }
                    },
                    error:function (){
                        alert("오류 발생");
                    }
                })
            })

            // 비밀번호 확인
            $(".checkPassword").on("keyup",function (){
                let pwd = $('.password').val();
                let checkPwd = $(this).val();
                console.log(checkPwd);
                if(pwd === checkPwd ){
                    console.log("맞음");
                    $("#checkPwdMsg").css("color", "green").text("비밀번호가 일치합니다.");
                } else {
                    console.log("다름");
                    $("#checkPwdMsg").css("color", "red").text("비밀번호가 다릅니다.");
                }
            })

            // 입력 누락 알림 메서드
            function checkFormValidity(){
                let username = $(".username").val().trim();
                let pwd = $(".password").val();
                let chekPwd = $(".checkPassword").val();
                let name = $(".name").val();
                let email = $(".email").val();
                let phone = $(".phone").val();

                if(username && pwd && chekPwd && name && email && phone){
                    $(".submitBtn").attr("disabled",false);
                } else {
                    $(".submitBtn").attr("disabled",true);
                }
            }
            $("input").on("keyup change",checkFormValidity);

            // 이메일 정규식 함수
            function isValidEmail(email){
                const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/; // 이메일 정규식
                return emailRegex.test(email);
            }

            // 회원가입 폼 제출
            // $("#registerForm").on("submit",function (e){
            //     let username = $(".username").val().trim();
            //     let pwd = $(".password").val();
            //     let chekPwd = $(".checkPassword").val();
            //     let name = $(".name").val();
            //     let email = $(".email").val();
            //     let phone = $(".phone").val();
            //
            //     // 1. 빈값 체크
            //     if(!username || !pwd || !checkPwd || !name || !email || !phone){
            //         $("#formError").text("모든 항목을 입력해주세요");
            //         e.preventDefault(); // 제출 막기
            //         return;
            //     }
            //
            //     // 2. 이메일 형식 체크
            //     if(!isValidEmail(email)){
            //         $("#formError").text("이메일 형식이 올바르지 않습니다");
            //         e.preventDefault(); // 제출 막기
            //         return;
            //     }
            //
            //     // 3. 비밀번호 확인
            //     if(pwd !== chekPwd){
            //         $("#formError").text("비밀버호가 일치하지 않습니다");
            //         e.preventDefault(); // 제출 막기
            //         return;
            //     }
            //
            //     // 4. 통과 시 메시지 지우기
            //     $("#formError").text("");
            // })
            //
            // // 입력 시 에러 메시지 실시간 제거
            // $("input").on("input", function () {
            //     $("#formError").text(""); // 실시간으로 에러 메시지 제거
            // });
        })
    </script>
</body>
</html>

package controller;

import service.UserService;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/checkuserid")
public class CheckUserIdServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("서블릿(컨트롤러) - doPost - 아이디중복체크(checkuserid) ");
        req.setCharacterEncoding("UTF-8");// 한글 아이디 대비
        String username = req.getParameter("username"); // 클라이언트가 전달한 username 파라미터 추출
        boolean isDuplicate = userService.isUsernameDuplicate(username); // 서비스 호출

        res.setContentType("application/json"); // 응답 데이터 설정 : 일반 텍스트
        res.getWriter().write(String.valueOf(isDuplicate)); // 결과 값을 문자열로 클라이언트 전송

    }
}
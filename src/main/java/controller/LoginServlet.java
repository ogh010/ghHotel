package controller;


import model.UserVO;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    // 사용자 서비스 객체 생성 (로그인 기능 담당)
    UserService userService = new UserServiceImpl();

    // 로그인 화면 보여주기 (GET)
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("서블릿(컨트롤러) - doGet - 로그인");
        req.getRequestDispatcher("/view/user/login.jsp").forward(req,res); // login.jsp로 포워딩

    }

    // 로그인 처리 (POST)
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("서블릿(컨트롤러) - doPost - 로그인");
        req.setCharacterEncoding("UTF-8"); // 한글 깨짐 방지

        // 사용자 입력값 가져오기
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 서비스 호출하여 로그인 시도
        UserVO loginUser = userService.login(username,password);
        System.out.println(loginUser);
        if(loginUser != null){
            req.getSession().setAttribute("loginUser",loginUser); // 로그인 성공시 세션 저장
            System.out.println("로그인 성공");
//            res.sendRedirect("/ghHotel2/main"); // 메인페이지로 리다이렉트
            res.sendRedirect(req.getContextPath() + "/view/user/main.jsp"); // ✅ main.jsp로 이동
        } else{
            System.out.println("로그인 실패");
            req.getRequestDispatcher("/view/user/login.jsp").forward(req,res);
        }
    }
}
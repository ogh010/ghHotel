package controller.user;


import model.user.UserVO;
import service.user.UserService;
import service.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 회원가입 서블릿(컨트롤러)
 */
@WebServlet("/register")
public class ResisterServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("서블릿(컨트롤러) - doGet");
        // 회원가입 페이지로 jsp 포워딩
        req.getRequestDispatcher("/view/user/register.jsp").forward(req,res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("서블릿(컨트롤러) - doPost");
        // 한글 깨짐 방지
        req.setCharacterEncoding("UTF-8");

        // 사용자 입력값 받기
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

        // vo 객체에 담기
        UserVO userVO = new UserVO();
        userVO.setUsername(username);
        userVO.setPassword(password);
        userVO.setName(name);
        userVO.setEmail(email);
        userVO.setPhone(phone);

        int result = userService.register(userVO);

        if(result>0){
            res.sendRedirect("/ghHotel2/login");
        } else {
            req.setAttribute("error", "회원가입 실패");
            req.getRequestDispatcher("/views/user/register.jsp").forward(req, res);
        }
    }
}
package controller.rsv;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/rsvStep3")
public class ReserveStep3Servelt extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        System.out.println("서블릿(컨트롤러) - doGet - rsvStep3");

        String[] options = req.getParameterValues("option"); // 여러개 선택
        String joinedOptions = String.join(",",options);

        req.setAttribute("joinedOptions", joinedOptions);

        req.getRequestDispatcher("/view/rsv/rsvStep4.jsp").forward(req, res);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}
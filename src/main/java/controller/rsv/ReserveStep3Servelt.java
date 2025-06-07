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

        String option = req.getParameter("option");
        int price = 0;

        switch (option){
            case "upgrade" : price = 30000; break;
            case "breakfast" : price = 15000; break;
            case "shuttle" : price = 20000; break;
            case "lateCheckout" : price = 10000; break;
            case "wine" : price = 25000; break;
        }

        req.setAttribute("option", option);
        req.setAttribute("totalAmount", Integer.parseInt(req.getParameter("totalAmount"))+price);
        req.getRequestDispatcher("/view/rsv/rsvStep4.jsp").forward(req, res);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}
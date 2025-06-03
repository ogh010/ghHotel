package controller.resv;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

@WebServlet("/rsvStep1")
public class ReserveStep1Servelt extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); // 한글 깨짐 방지
        System.out.println("서블릿(컨트롤러) - doGet - rsvStep1");

        //hotelId=1&checkIn=2025-06-03&checkOut=2025-06-04
        String hotelId = req.getParameter("hotelId");
        String checkIn = req.getParameter("checkIn");
        String checkOut = req.getParameter("checkOut");

        req.setAttribute("hotelId",hotelId);
        req.setAttribute("checkIn",checkIn);
        req.setAttribute("checkOut",checkOut);

        req.getRequestDispatcher("/view/rsv/rsvStep2.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
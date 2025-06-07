package controller.rsv;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@WebServlet("/rsvStep1")
public class ReserveStep1Servelt extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); // 한글 깨짐 방지
        System.out.println("서블릿(컨트롤러) - doGet - rsvStep1");

        //hotelId=1&checkIn=2025-06-03&checkOut=2025-06-04
        String hotelId = req.getParameter("hotelId"); // 호텔명
        String checkIn = req.getParameter("checkIn"); // 체크인
        String checkOut = req.getParameter("checkOut"); // 체크아웃
        String adultCount = req.getParameter("adultCount"); // 어른 수
        String childCount = req.getParameter("childCount"); // 아이 수
        int price = 0;

        LocalDate checkInDate = LocalDate.parse(checkIn);
        LocalDate checkOutDate = LocalDate.parse(checkOut);

        // 숙박일수 = 체크아웃 - 체크인
        long nights = ChronoUnit.DAYS.between(checkInDate,checkOutDate);

        // 호텔 가격
        switch (hotelId) {
            case "1": price = 200000; break; // 서울
            case "2" : price = 150000; break; // 부산
            case "3" : price = 100000; break; // 제주
        }

        int totalAmount = Math.toIntExact(price * nights);

        req.setAttribute("hotelId",hotelId); // 호텔id
        req.setAttribute("checkIn",checkIn); // 체크인
        req.setAttribute("checkOut",checkOut); // 체크아웃
        req.setAttribute("nights",nights); // 숙박일
        req.setAttribute("adultCount",adultCount); // 어른수
        req.setAttribute("childCount",childCount); // 아이수
        req.setAttribute("totalAmount",totalAmount); // 총금액

        req.getRequestDispatcher("/view/rsv/rsvStep2.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
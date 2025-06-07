package controller.payment;


import com.fasterxml.jackson.databind.ObjectMapper;
import dao.rsv.ReservationDAO;
import model.payment.ItemsVO;
import model.payment.OrderResVO;
import model.payment.OrderVO;
import model.rsv.ReservationVO;
import model.user.UserVO;
import service.rsv.ReservationService;
import service.rsv.ReservationServiceImpl;
import util.OrderAPIClient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet("/reserveSubmit")
public class reserveSubmitServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("서블릿(컨트롤러) - doPost - 주문");
        req.setCharacterEncoding("UTF-8");
        ReservationService rservice = new ReservationServiceImpl();

        //  폼에서 넘어온 예약자 정보 받기
        String hotelId = req.getParameter("hotelId"); // 호텔ID
        String checkIn = req.getParameter("checkIn"); // 체크인
        String checkOut = req.getParameter("checkOut"); // 체크아웃
        String adultCount = req.getParameter("adultCount"); // 어른 수
        String childCount = req.getParameter("childCount"); // 아이 수
        String totalAmount = req.getParameter("totalAmount"); // 총 금액
        String roomType = req.getParameter("roomType"); // 객실타입
        String option = req.getParameter("option"); // 옵션


        // 예약 정보를 VO 에 담기
        OrderVO ordervo = new OrderVO();
        ordervo.setReceiptNumber(UUID.randomUUID().toString().replace("-","").substring(0,32)); // 주문번호
        ordervo.setTotalAmount(Integer.parseInt(totalAmount)); //
        ordervo.setUserId(String.valueOf(((UserVO)req.getSession().getAttribute("loginUser")).getUserId())); // 주문 유저아이디
        ordervo.setStoreId("ghHotel"); // 주문 스토어아이디
        ordervo.setCurrency("KRW");
        ordervo.setMemo("test");
        ItemsVO itemsvo = new ItemsVO();
        itemsvo.setItemNumber(UUID.randomUUID().toString().replace("-","").substring(0,32));
        itemsvo.setProductName(hotelId);
        itemsvo.setQuantity(1);
        itemsvo.setUnitPrice(Integer.parseInt(totalAmount));
        List<ItemsVO> itemslist = new ArrayList<>();
        itemslist.add(itemsvo);
        ordervo.setItems(itemslist);

        // 외부 주문 api 호출
        try {
            // 1. 외부 api 호출해서 json 문자열 응답 받기
            String jsonResponse = OrderAPIClient.createOrder(ordervo);

            // 2. 응답 문자열 -> orderResVO 로 변환
            ObjectMapper mapper = new ObjectMapper();
            OrderResVO resVO = mapper.readValue(jsonResponse, OrderResVO.class);

            System.out.println(resVO);

            // 3. 성공 여부 확인
            if("0000".equals(resVO.getResultCode())){
                UserVO loginUser = (UserVO) req.getSession().getAttribute("loginUser");
                ReservationVO rvo = new ReservationVO();
                rvo.setUserId(loginUser.getUserId());
                rvo.setHotelId(Integer.parseInt(hotelId));
                rvo.setCheckInDate(Date.valueOf(checkIn));
                rvo.setCheckOutDate(Date.valueOf(checkOut));
                rvo.setAdultCount(Integer.parseInt(adultCount));
                rvo.setChildCount(Integer.parseInt(childCount));
                rvo.setRoomType(roomType);

                ReservationDAO rdao = new ReservationDAO();
                int result = rdao.insertReservation(rvo);

                if(result > 0){
                    // 성공 : 주문번호 저장 후 결제페이지로 이동
                    req.getSession().setAttribute("orderNumber",resVO.getOrderNumber());
                    res.sendRedirect("/ghHotel2/main");
                } else {
                    req.setAttribute("error",resVO.getResultMsg());
                    res.sendRedirect("/ghHotel2/");
                }


            } else{
                req.setAttribute("error",resVO.getResultMsg());
                res.sendRedirect("/ghHotel2/");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
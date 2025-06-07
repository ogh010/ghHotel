package dao.rsv;

import model.rsv.ReservationVO;
import util.DBUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class ReservationDAO {
    public int insertReservation(ReservationVO rvo){
        System.out.println("dao DB연결 - ReservationDAO.insertReservation");
        int result = 0;
        String sql = """
                INSERT INTO reservation (RES_ID,USER_ID,HOTEL_ID,CHECK_IN_DATE,CHECK_OUT_DATE,RES_DATE,ADULT_COUNT,CHILD_COUNT,ROOM_TYPE,STATUS) 
                VALUES(SEQ_RESERVATION.NEXTVAL,?,?,?,?,sysdate,?,?,?,?)
                """;
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1,rvo.getUserId());
            pstmt.setInt(2,rvo.getHotelId());
            pstmt.setDate(3, (Date) rvo.getCheckInDate());
            pstmt.setDate(4, (Date) rvo.getCheckOutDate());
            pstmt.setInt(5,rvo.getAdultCount());
            pstmt.setInt(6,rvo.getChildCount());
            pstmt.setString(7,rvo.getRoomType());
            pstmt.setString(8,"예약완료");

            result = pstmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}

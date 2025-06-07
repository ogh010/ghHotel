package model.rsv;

import lombok.Data;

import java.util.Date;

@Data
public class ReservationVO {
    private int resId; // 예약 아이디
    private int userId; // 사용자 아이디
    private int hotelId; // 호텔 아이디
    private Date checkInDate; // 체크인
    private Date checkOutDate; // 체크아웃
    private Date resDate; // 예약일
    private int adultCount; // 어른 수
    private int childCount; // 아이 수
    private String roomType; // 객실 타입
    private String status; // 예약상태
}

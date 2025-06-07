package model.payment;

import lombok.Data;

import java.util.List;

@Data
public class OrderVO {
    private String receiptNumber; // 예약번호
    private int totalAmount; // 예약 총금액
    private String userId; // 테스트 유저
    private String storeId; // 예약 스토어 아이디
    private String currency; // 금액 단위
    private String memo; // 메모
    private List<?> items; // ItemsVO
}


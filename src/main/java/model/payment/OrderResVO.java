package model.payment;

import lombok.Data;

@Data
public class OrderResVO {
    private String resultCode;
    private String orderNumber;
    private String resultMsg;
}

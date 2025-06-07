package model.payment;

import lombok.Data;

@Data
public class ItemsVO {
    private String itemNumber;
    private String productName;
    private int quantity;
    private int unitPrice;
}

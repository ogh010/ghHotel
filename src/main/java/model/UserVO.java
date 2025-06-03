package model;

import lombok.Data;
import java.sql.Date;

// 회원 정보를 담는 vo 클래스 (Value Object)
@Data
public class UserVO {
    private int userId;
    private String username;
    private String password;
    private String name;
    private String email;
    private String phone;
    private Date regDate;
}

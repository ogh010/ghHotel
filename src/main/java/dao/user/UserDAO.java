package dao.user;

import model.user.UserVO;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    // 회원가입 메서드
    public int insertUser(UserVO userVO){

        System.out.println("dao DB연결 - UserDAO.insertUser");
        int result = 0;

        String sql = "insert into users (user_id,username,password,name,email,phone,reg_date) values (SEQ_USER.NEXTVAL,?,?,?,?,?,sysdate)";

        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);


            pstmt.setString(1, userVO.getUsername());
            pstmt.setString(2,userVO.getPassword());
            pstmt.setString(3, userVO.getName());
            pstmt.setString(4,userVO.getEmail());
            pstmt.setString(5,userVO.getPhone());

            result = pstmt.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    // 아이디 중복 체크 메서드
    public boolean isUsernameDuplicate(String username){
        boolean result = false;
        System.out.println("dao DB연결 - UserDAO.isUsernameDuplicate - 아이디 중복 체크 ");
        String sql = "select count(*) from users where username=?";

        try {
            Connection conn = DBUtil.getConnection(); // DB 연결
            PreparedStatement pstms = conn.prepareStatement(sql); // sql 준비

            pstms.setString(1,username); // 데이터 바인딩

            ResultSet rs = pstms.executeQuery(); // select 실행 -> 결과 반환

            if(rs.next() && rs.getInt(1)>0){ // 결과가 있고, 한개 이상 존재하면 중복으로 판단
                result = true; // 아이디 존재(중복)
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result; // true 면 중복
    }

    // 로그인 메서드
    public UserVO login(String username, String password) {
        System.out.println(username);
        System.out.println(password);
        System.out.println("dao DB연결 - UserDAO.isUsernameDuplicate - 로그인 ");
        UserVO userVO = null;
        String sql = "select * from users where username = ? and password = ?";
        try{
            // DB 연결 , sql 준비
            Connection conn = DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // 데이터 바인딩
            pstmt.setString(1,username);
            pstmt.setString(2,password);

            // sql 실행 결과
            ResultSet rs = pstmt.executeQuery();

            System.out.println(rs);

            // 로그인 성공 후 빈userVO에 값 setter
            if(rs.next()){
                userVO = new UserVO();
                userVO.setUsername(rs.getString("username"));
                userVO.setPassword(rs.getString("password"));
                userVO.setName(rs.getString("name"));
                userVO.setEmail(rs.getString("email"));
                userVO.setPhone(rs.getString("phone"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return userVO;
    }
}

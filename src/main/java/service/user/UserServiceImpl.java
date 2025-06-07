package service.user;

import dao.user.UserDAO;
import model.user.UserVO;

public class UserServiceImpl implements UserService{
    UserDAO userDAO = new UserDAO();

    // 회원가입 - 구현체
    @Override
    public int register(UserVO userVO) {
        System.out.println("서비스(서비스 구현체impl)-UserServiceImpl");
        return userDAO.insertUser(userVO);
    }

    // 아이디 중복체크 - 구현체
    @Override
    public boolean isUsernameDuplicate(String username) {
        System.out.println("서비스(아이디 중복체크 구현체impl)-isUsernameDuplicate");
        return userDAO.isUsernameDuplicate(username);
    }

    // 로그인 - 구현체
    @Override
    public UserVO login(String username, String password) {
        System.out.println("서비스(로그인 구현체impl)-login");
        return userDAO.login(username,password);
    }
}

package service;

import model.UserVO;

public interface UserService {

    // 회원가입 - 인터페이스
    int register(UserVO userVO);

    // 아이디 중복 체크 - 인터페이스
    boolean isUsernameDuplicate(String username);

    // 로그인 - 인터페이스
    UserVO login(String username, String password);
}

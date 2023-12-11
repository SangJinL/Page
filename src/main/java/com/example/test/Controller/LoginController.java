package com.example.test.Controller;
import com.example.test.Entity.Signup;

import org.apache.catalina.User;
import com.example.test.Entity.Signup;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestBody Signup  user) { // 'User' 클래스 대신 'Signup' 클래스 사용
        // 로그인 로직 구현
        // 예를 들어, 데이터베이스에서 사용자 찾기
        String Id = user.getId();
        String password = user.getPassword();

        // 여기서는 단순히 ID와 비밀번호가 'admin'인 경우에만 로그인 성공으로 가정
        if (!(!"admin".equals(Id) || !"admin".equals(password))) {
            return "로그인 성공";
        } else {
            return "로그인 실패";
        }
    }
}

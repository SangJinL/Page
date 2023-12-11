package com.example.test.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.test.Entity.Signup; // Import the Signup class from your entity package

@RestController
public class SignupController {

    @PostMapping("/signup") // Use lowercase for the endpoint
    public String signup(@RequestBody Signup user) { // Use the Signup class instead of User
        // 회원가입 로직 구현
        // 예를 들어, 데이터베이스에 사용자 정보 저장
        System.out.println("이름: " + user.getName());
        System.out.println("아이디: " + user.getId()); // Use getId() instead of getUsername()
        System.out.println("비밀번호: " + user.getPassword());
        System.out.println("이메일: " + user.getEmail());

        return "회원가입 성공";
    }
}

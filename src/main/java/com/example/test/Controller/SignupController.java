package com.example.test.Controller;

import com.example.test.DTO.UserDTO;
import com.example.test.Entity.*;
import com.example.test.Repository.SignupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

@RestController
@RequestMapping("/signup")
public class SignupController {

    @Autowired
    private SignupRepository signupRepository;

    @PostMapping("/") // 엔드포인트 URL 변경
    public ResponseEntity<String> signup(@RequestBody UserDTO userDTO) {
        // 입력 값의 유효성 검사 (예: 빈 값 확인)

        if (StringUtils.isEmpty(userDTO.getName()) ||
                StringUtils.isEmpty(userDTO.getUserid()) ||
                StringUtils.isEmpty(userDTO.getPassword()) ||
                StringUtils.isEmpty(userDTO.getEmail())) {
            return ResponseEntity.badRequest().body("모든 필드를 입력해주세요.");
        }

        // 비밀번호 해시화 (실제 서비스에서는 더 강력한 알고리즘 사용)
        String hashedPassword = hashPassword(userDTO.getPassword());
        userDTO.setPassword(hashedPassword);

        // Create a Signup entity from the UserDTO
        User user = new User(userDTO.getUserid(), userDTO.getName(), userDTO.getPassword(), userDTO.getEmail());

        // Implement the signup logic
        User savedUser = signupRepository.save(user);

        if (savedUser != null) {
            return ResponseEntity.ok("회원가입 성공");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("회원가입 실패");
        }
    }

    private String hashPassword(String password) {
        // 비밀번호 해시화 로직을 구현하세요 (예: BCrypt 등 사용)
        // 해시화된 비밀번호를 반환하세요
        return password;
    }
}

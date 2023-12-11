package com.example.test.Service;

import com.example.test.Repository.SignupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private SignupRepository signupRepository;

    public boolean authenticate(String id, String password) {
        // 인증 로직 구현 (예: 사용자 찾기, 비밀번호 검증)
        // 임시 구현: 단순히 ID와 비밀번호가 'admin'인 경우만 검증
        return "admin".equals(id) && "admin".equals(password);
    }
}

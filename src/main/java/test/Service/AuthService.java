package test.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.Entity.User;
import test.Repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private static UserRepository userRepository; // UserRepository를 주입받아야 합니다.

    public static void save(User user) {
        User save = userRepository.save(user);// 실제 저장 로직 구현
    }

    public boolean authenticate(String id, String password) {
        // 인증 로직 구현 (예: 사용자 찾기, 비밀번호 검증)
        // 임시 구현: 단순히 ID와 비밀번호가 'admin'인 경우만 검증
        return "admin".equals(id) && "admin".equals(password);
    }
}
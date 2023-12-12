package test.Config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;

    // 생성자를 통해 PasswordEncoder 주입 (예: BCryptPasswordEncoder)
    public SecurityUserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 실제 애플리케이션에서는 여기서 데이터베이스에서 사용자를 조회합니다.

        // 예시를 위해 하드코딩된 사용자 정보 반환
        if ("user".equals(username)) {
            return User.builder()
                    .username("user")
                    .password(passwordEncoder.encode("password")) // 실제 비밀번호는 암호화하여 저장해야 함
                    .roles("USER") // 권한 설정
                    .build();
        } else {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + username);
        }
    }
}

package test.Controller;

import test.DTO.UserDTO;
import test.Entity.User;
import test.Repository.SignupRepository;
import test.Service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private SignupRepository signupRepository;

    // 로그인 페이지
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // 로그인 처리
    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<String> login(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (authService.authenticate(username, password)) {
            return ResponseEntity.ok("/main");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패");
        }
    }

    // 회원가입 처리
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody UserDTO userDTO) {
        // 입력 값의 유효성 검사
        if (StringUtils.isEmpty(userDTO.getName()) ||
                StringUtils.isEmpty(userDTO.getUserid()) ||
                StringUtils.isEmpty(userDTO.getPassword()) ||
                StringUtils.isEmpty(userDTO.getEmail())) {
            return ResponseEntity.badRequest().body("모든 필드를 입력해주세요.");
        }

        // 비밀번호 해시화
        String hashedPassword = hashPassword(userDTO.getPassword());
        userDTO.setPassword(hashedPassword);

        try {
            // User 엔티티 생성 및 저장
            User user = new User(userDTO.getUserid(), userDTO.getName(), userDTO.getPassword(), userDTO.getEmail());
            signupRepository.save(user);

            return ResponseEntity.ok("회원가입 성공");
        } catch (Exception e) {
            // 데이터베이스 저장 중에 발생하는 예외 처리
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("회원가입 중 오류 발생: " + e.getMessage());
        }
    }


    private String hashPassword(String password) {
        // 비밀번호 해시화 로직 구현
        return password; // 실제 애플리케이션에서는 보안을 위해 강력한 해시 알고리즘 사용
    }
}

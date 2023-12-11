package com.example.test.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank(message = "아이디는 필수 항목입니다.")
    private String user_id; // userid 필드 추가

    @NotBlank(message = "이름은 필수 항목입니다.")
    private String user_name;


    @NotBlank(message = "비밀번호는 필수 항목입니다.")
    private String user_password;

    @NotBlank(message = "이메일은 필수 항목입니다.")
    @Email(message = "올바른 이메일 주소를 입력해주세요.")
    private String user_email;

    // 매개변수가 있는 생성자
    public User(String userid, String name, String password, String email) {
        this.user_id = userid;
        this.user_name = name;
        this.user_password = password;
        this.user_email = email;
    }
}

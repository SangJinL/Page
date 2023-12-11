package com.example.test.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDTO {
    // Getter 및 Setter 메서드
    private String userid;
    private String name;
    private String password;
    private String email;

    // 기본 생성자
    public UserDTO() {
    }

    // 매개변수가 있는 생성자
    public UserDTO(String user_id, String user_name, String user_password, String user_email) {
        this.userid = userid;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userid='" + userid + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

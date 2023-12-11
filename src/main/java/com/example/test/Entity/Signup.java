package com.example.test.Entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Signup {
    // name의 getter와 setter
    private String name;
    // userid의 getter와 setter
    private String Id;
    // password의 getter와 setter
    private String password;
    // email의 getter와 setter
    private String email;

    // 기본 생성자
    public Signup() {
    }

    // 매개변수가 있는 생성자
    public Signup(String name, String Id, String password, String email) {
        this.name = name;
        this.Id = Id;
        this.password = password;
        this.email = email;
    }
}
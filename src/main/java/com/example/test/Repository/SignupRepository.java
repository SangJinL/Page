package com.example.test.Repository;

import com.example.test.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignupRepository extends JpaRepository<User, Long> {
    // 필요한 추가 메소드 정의
}

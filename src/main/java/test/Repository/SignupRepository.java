package test.Repository;

import test.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignupRepository extends JpaRepository<User, Long> {
    // 필요한 추가 메소드 정의
}

package test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // 기본 CRUD 메서드는 JpaRepository로부터 자동으로 제공받습니다.
    // 추가적인 사용자 정의 메서드를 여기에 정의할 수 있습니다.
}

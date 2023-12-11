package test.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId; // userid 필드 변경

    @NotBlank(message = "이름은 필수 항목입니다.")
    private String userName; // user_name 필드 변경

    @NotBlank(message = "비밀번호는 필수 항목입니다.")
    private String userPassword; // user_password 필드 변경

    @NotBlank(message = "이메일은 필수 항목입니다.")
    @Email(message = "올바른 이메일 주소를 입력해주세요.")
    private String userEmail; // user_email 필드 변경
}

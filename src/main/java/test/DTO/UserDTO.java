package test.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String userid;
    private String name;
    private String password;
    private String email;

    @Override
    public String toString() {
        return "UserDTO{" +
                "userid='" + userid + '\'' +
                ", name='" + name + '\'' +
                ", password='[PROTECTED]'" + // 비밀번호는 로그에 나타내지 않기 위해 보호
                ", email='" + email + '\'' +
                '}';
    }
}

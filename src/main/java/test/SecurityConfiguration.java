package test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize ->
                        authorize
                                .requestMatchers("/", "/main", "/signup").permitAll() // 특정 경로에 대한 접근 허용
                                .anyRequest().authenticated() // 그 외의 모든 요청은 인증 필요
                )
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/login") // 사용자 정의 로그인 페이지
                                .permitAll()
                )
                .logout(logout ->
                        logout.permitAll() // 로그아웃에 대한 모든 요청 허용
                );

        return http.build();
    }
}

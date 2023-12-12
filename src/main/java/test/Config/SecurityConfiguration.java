package test.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Autowired
    private SecurityUserService securityUserService;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfiguration(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // CSRF 보호 비활성화
                .authorizeRequests()
                .antMatchers("/public/**").permitAll() // '/public/**' 경로는 인증 없이 접근 가능
                .anyRequest().authenticated() // 그 외 모든 요청은 인증 필요
                .and()
                .formLogin()
                .loginPage("/login") // 사용자 정의 로그인 페이지
                .defaultSuccessUrl("/home", true) // 로그인 성공 시 이동할 페이지
                .permitAll() // 모든 사용자가 로그인 페이지 접근 가능
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout") // 로그아웃 성공 시 이동할 페이지
                .permitAll(); // 로그아웃 허용

        http.userDetailsService(securityUserService)
                .passwordEncoder(passwordEncoder); // 사용자 서비스 및 비밀번호 인코더 설정

        return http.build();
    }
}

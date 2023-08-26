package com.example.securitystudy.config;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfig {

        //비밀번호 암호화를 위한 것.
        @Bean
        PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }
        
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().disable()
                .authorizeHttpRequests(request -> request
                	.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/images/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/view/join")).permitAll()
                        // view/admin에 접근하려면 roles의 ADMIN만 접근할 수 있다. 
                        .requestMatchers(new AntPathRequestMatcher("/view/admin")).hasAnyRole("ADMIN") //이건 test
                        .requestMatchers(new AntPathRequestMatcher("/view/setting/admin")).hasAnyRole("ADMIN")
                        // view/admin에 접근하려면 roles의 USER만 접근할 수 있다. 
                        //따로 config.UserAuthorize에서 설정을 해주면 이 곳에서 경로를 지정해주지 않아도 된다.
                        //나는 그냥 여기로 경로 지정해줄거임.
                        .requestMatchers(new AntPathRequestMatcher("/view/setting/user")).hasAnyRole("USER")
                        .requestMatchers(new AntPathRequestMatcher("/auth/join")).permitAll()
                        .anyRequest().authenticated()	// 어떠한 요청이라도 인증필요
                )
                .formLogin(login -> login
                .loginPage("/view/login")	// [A] 커스텀 로그인 페이지 지정
                .failureUrl("/test") // 로그인 실패 후 이동 페이지
                .loginProcessingUrl("/login-process")	// [B] submit 받을 url
                .usernameParameter("userid")	// [C] submit할 아이디
                .passwordParameter("pw")	// [D] submit할 비밀번호
                .defaultSuccessUrl("/view/dashboard", true)
                .permitAll()
                )
                .logout(withDefaults());	// 로그아웃은 기본설정으로 (/logout으로 인증해제)

        return http.build();
    }
}
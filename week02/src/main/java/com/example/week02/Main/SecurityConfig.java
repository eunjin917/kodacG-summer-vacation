package com.example.week02.Main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/product").permitAll()  // /product URL은 인증 없이 접근 가능
                        .anyRequest().authenticated()  // 다른 모든 요청은 인증 필요
                )
                .formLogin(withDefaults());  // 기본 폼 로그인 사용

        return http.build();
    }
}

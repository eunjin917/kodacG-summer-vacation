package com.example.week02.User;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter // 추가하여 자동으로 Getter와 Setter 생성
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "user_tb")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String user_id;

    @Column(nullable = false, length = 100)
    private String username;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false)
    private LocalDate sign_date;

    @Builder
    public User(String user_id, String username, String password, String email, LocalDate sign_date) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.sign_date = sign_date;
    }
}

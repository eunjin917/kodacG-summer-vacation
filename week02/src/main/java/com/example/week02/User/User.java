package com.example.week02.User;

import jakarta.persistence.*;
import lombok.Builder;

import java.time.LocalDate;

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

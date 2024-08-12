package com.example.week02.User;

import jakarta.persistence.*;
import lombok.Builder;

import java.util.Date;

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
    @Temporal(TemporalType.DATE)
    private Date sign_date;

    @Builder
    public User(String user_id, String username, String password, String email, Date sign_date) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.sign_date = sign_date;
    }


}

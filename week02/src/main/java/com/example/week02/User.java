package com.example.week02;

import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String userId;

    @Column(nullable = false)
    private String userPassword;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int point;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String deliveyAddress;

    @Builder
    public User(long id, String userId, String userPassword, String name, int point, String phoneNumber, String email, String deliveyAddress) {
        this.id = id;
        this.userId = userId;
        this.userPassword = userPassword;
        this.name = name;
        this.point = point;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.deliveyAddress = deliveyAddress;
    }
}

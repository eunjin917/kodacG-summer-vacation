package com.example.week02.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.DateTimeException;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String email;
    private String name;
    private String password;
    private LocalDateTime registrationDate;

    // 기본 생성자 추가
    public MemberEntity() {
    }

    // 매개변수가 있는 생성자
    public MemberEntity(String email, String name, String password, LocalDateTime registrationDate) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.registrationDate = registrationDate;
    }
}


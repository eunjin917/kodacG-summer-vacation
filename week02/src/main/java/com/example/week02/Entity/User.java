package com.example.week02.Entity;

//- user_id(pk) 유저 아이디
//- user_name   유저 이름
//- password    비밀번호
//- email       이메일
//- sign_date   가입일자

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@Entity
@Table(name = "user_tb", uniqueConstraints = @UniqueConstraint(name
        = "uk_user_email", columnNames = "email"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(nullable =false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable =  false)
    private LocalDateTime signDate;

    //주문과의 관계
    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE,orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

    @Builder
    public User( String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.signDate = LocalDateTime.now();
    }
}

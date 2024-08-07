package com.example.week02.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; // 주문 고유 ID

    private String userToken; // 사용자의 인증 토큰

    private LocalDateTime orderDate; // 주문 날짜

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderItemEntity> orderItems; // 주문 항목 리스트

    // 기본 생성자
    public OrderEntity() {}

    // 생성자
    public OrderEntity(String userToken, LocalDateTime orderDate) {
        this.userToken = userToken;
        this.orderDate = orderDate;
    }
}

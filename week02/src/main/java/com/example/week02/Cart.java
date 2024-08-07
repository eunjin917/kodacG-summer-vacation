package com.example.week02;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.security.Timestamp;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "cart_tb")


public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cart_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", nullable = false)
    private User user;

    @Column(nullable = false)
    private Timestamp cart_price;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal total_price;

    @Builder
    public Cart(String cart_id, User user, Timestamp cart_price, BigDecimal total_price) {
        this.cart_id = cart_id;
        this.user = user;
        this.cart_price = cart_price;
        this.total_price = total_price;

    }
}

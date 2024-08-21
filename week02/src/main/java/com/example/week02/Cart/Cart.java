package com.example.week02.Cart;

import com.example.week02.User.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter; // 추가

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter // 추가하여 자동으로 Getter와 Setter 생성
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
    private LocalDateTime cart_date;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal total_price;

    @Builder
    public Cart(String cart_id, User user, LocalDateTime cart_date, BigDecimal total_price) {
        this.cart_id = cart_id;
        this.user = user;
        this.cart_date = cart_date;
        this.total_price = total_price;
    }
}

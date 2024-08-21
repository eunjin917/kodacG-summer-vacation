package com.example.week02.Order;

import com.example.week02.User.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "order_tb")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String orderid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private Timestamp order_date;

    @Column(length = 255)
    private String delivery;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal total_amount;

    @Column(length = 255)
    private String delivery_state;

    @Builder
    public Order(String orderid, User user, Timestamp order_date, String delivery, BigDecimal total_amount, String delivery_state) {
        this.orderid = orderid;
        this.user = user;
        this.order_date = order_date;
        this.delivery = delivery;
        this.total_amount = total_amount;
        this.delivery_state = delivery_state;
    }
}

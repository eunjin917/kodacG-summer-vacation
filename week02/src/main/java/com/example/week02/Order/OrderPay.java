package com.example.week02.Order;

import com.example.week02.Pay.Pay;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "order_pay_tb")

public class OrderPay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String orderpayid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pay_id", nullable = false)
    private Pay pay;

    @Builder
    public OrderPay(String orderpayid, Order order, Pay pay) {
        this.orderpayid = orderpayid;
        this.order = order;
        this.pay = pay;
    }
}

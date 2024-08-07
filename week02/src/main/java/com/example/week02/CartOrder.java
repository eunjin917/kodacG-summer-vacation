package com.example.week02;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "cart_order_tb")

public class CartOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cartorderid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Builder
    public CartOrder(String cartorderid, Cart cart, Order order) {
        this.cartorderid = cartorderid;
        this.cart = cart;
        this.order = order;
    }
}

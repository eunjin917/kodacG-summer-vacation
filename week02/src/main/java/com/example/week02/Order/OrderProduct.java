package com.example.week02.Order;

import com.example.week02.Product;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.swing.text.html.Option;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "order_product_tb")

public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String orderidproduct;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @Column(nullable = false)
    private int quantity = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    private Option option;

    @Column(nullable = true)
    private String option_description;

    @Builder
    public OrderProduct(String orderidproduct, Order order, Product product, int quantity, Option option, String option_description){
        this.orderidproduct = orderidproduct;
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.option = option;
        this.option_description = option_description;
    }
}

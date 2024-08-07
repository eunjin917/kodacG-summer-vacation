package com.example.week02.Entity;

//- order_product_id(pk)
//- order_id(fk)          주문 번호
//- product_id(fk)        상품 아이디
//- quantity              주문 수량
//- total_price           총 주문 금액
//- option_description    옵션 설명

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter

@Entity
@Table(name = "order_product_tb")
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderProductId;

    @Column(nullable = false)
    private int quantity;

    @Column(columnDefinition = "TEXT")
    private String optionDescription;

    @Column(nullable = false)
    private int totalPrice;

    // 주문과의 관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable =false)
    private Order order;

    // 상품과의 관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;

    //장바구니와의 관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id",nullable = false)
    private Cart cart;

    //결제와의 관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id",nullable = false)
    private Payment payment;


    @Builder
    public OrderProduct(int quantity, String optionDescription, Order order, Product product,
    int totalPrice) {
        this.quantity = quantity;
        this.optionDescription = optionDescription;
        this.order = order;
        this.product = product;
        this.totalPrice = totalPrice;
    }

}

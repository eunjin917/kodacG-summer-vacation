package com.example.week02.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; // 주문 항목 고유 ID

    private Long optionId; // 선택된 옵션 ID
    private int quantity; // 수량
    private double price; // 개별 항목 가격

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order; // 연관된 주문

    // 기본 생성자
    public OrderItemEntity() {}

    // 생성자
    public OrderItemEntity(Long optionId, int quantity, double price, OrderEntity order) {
        this.optionId = optionId;
        this.quantity = quantity;
        this.price = price;
        this.order = order;
    }
}

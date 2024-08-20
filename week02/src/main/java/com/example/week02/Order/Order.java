package com.example.week02.Order;


//  order_id(pk)     주문 번호
//- user_id(fk)      유저 아이디
//- order_date       주문 일시
//- delivery         배송지
//- delivery_status 배송 상태

import com.example.week02.User.User;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long OrderId;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String delivery;

    @Column(nullable = false)
    private LocalDateTime orderDate;

    @Column(nullable = false)
    private String deliveryStatus;

    // 유저와의 관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    //주문상품과의 관계
    @OneToMany(mappedBy = "order",cascade = CascadeType.REMOVE,orphanRemoval = true)
    private List<OrderProduct> orders = new ArrayList<>();

    @Builder
    public Order(String delivery, LocalDateTime orderDate, int totalPrice, String deliveryStatus) {
        this.delivery = delivery;
        this.orderDate = orderDate;

    }



}

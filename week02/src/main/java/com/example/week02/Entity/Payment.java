package com.example.week02.Entity;

//- payment_id(pk)     결제 아이디
//- order_product_id(fk) 주문 번호
//- payment_date       결제 일시
//- amount             결제 금액
//- payment_method     결제 방식
//- payment_status     결제 상태

import java.util.*;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter

@Entity
@Table(name = "payment")

public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;

    @OneToMany(mappedBy = "payment", cascade = CascadeType.REMOVE,orphanRemoval = true)
    private List <OrderProduct> item = new ArrayList<>();

    @Column(nullable = false)
    private LocalDateTime paymentDate;

    @Column(nullable = false)
    private String payment_method;

    @Column(nullable = false)
    private String payment_status;

    @Builder
    public Payment(String payment_method, String payment_status, LocalDateTime paymentDate){
        this.payment_method = payment_method;
        this.payment_status = payment_status;
        paymentDate = LocalDateTime.now();
    }
}

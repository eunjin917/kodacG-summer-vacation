package com.example.week02.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name; // 옵션 이름 (예: 색상, 사이즈 등)
    private int price; // 옵션 가격 (기본 가격에 추가될 수 있음)

    @ManyToOne
    @JoinColumn(name = "item_id")
    private ItemEntity itemEntity; // 이 옵션이 속한 상품 꾸러미
}



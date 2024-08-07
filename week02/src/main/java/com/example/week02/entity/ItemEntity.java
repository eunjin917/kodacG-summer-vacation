package com.example.week02.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name; // 상품 꾸러미 이름
    private String imageUrl; // 상품 꾸러미 이미지 URL
    private int price; // 상품 꾸러미 가격 (옵션 최소가격)
    private LocalDateTime createdDate; // 상품 꾸러미 등록 날짜

    @OneToMany(mappedBy = "itemEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OptionEntity> optionEntities; // 상품 옵션 리스트
}



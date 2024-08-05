package com.example.week02.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; // 장바구니 고유 ID

    private String userToken; // 사용자의 인증 토큰

    private Long optionId; // 선택된 옵션 ID

    private int quantity; // 수량


    // 기본 생성자
    public CartEntity() {}

    // 생성자
    public CartEntity(String userToken, Long optionId, int quantity) {
        this.userToken = userToken;
        this.optionId = optionId;
        this.quantity = quantity;
    }


}


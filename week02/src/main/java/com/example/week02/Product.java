package com.example.week02;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "product_tb")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String productid;

    @Column(nullable = false, length = 100)
    private String productname;

    @Column(nullable = false, length = 100)
    private String price;

    @Column(nullable = false, length = 100)
    private String stock;

    @Column(nullable = false, length = 100)
    private String description;

    @Column(nullable = true, precision = 10, scale = 2)
    private BigDecimal discount_price;

    @Builder
    public Product(String productname, String price, String stock, String description, BigDecimal discount_price) {
        this.productid = productid;
        this.productname = productname;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.discount_price = discount_price;
    }

}

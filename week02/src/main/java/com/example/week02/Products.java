package com.example.week02;

import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private int price;

    private String image;

    @Column(nullable = false)
    private int ShippingCost;

    @Builder
    public Products(long id, String productName, int price, String image, int ShippingCost) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.image = image;
        this.ShippingCost = ShippingCost;

    }
}

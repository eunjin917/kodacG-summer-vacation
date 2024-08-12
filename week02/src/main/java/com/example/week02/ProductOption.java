package com.example.week02;


import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity

public class ProductOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private String productType;

    @Column(nullable = false)
    private String shippingMethod;

    @Column(nullable = false)
    private int productQuantity;

    @Builder
    public ProductOption(long id, Product product, String productType, String shippingMethod, int productQuantity) {
        this.id = id;
        this.product = product;
        this.productType = productType;
        this.shippingMethod = shippingMethod;
        this.productQuantity = productQuantity;
    }
}

package com.example.week02.Product;

//- product_id(pk)   상품 아이디
// - option_id(fk)
//- product_name     상품 이름
//- image            상품 사진
//- price            가격
//- description      상품 설명

import com.example.week02.Option.Option;
import com.example.week02.Order.OrderProduct;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter

@Entity
@Table(name = "product",uniqueConstraints = @UniqueConstraint(name = "uk_product_name",
columnNames = "productName"))
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String productName;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String productDesc;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String image;

    // 옵션과의 관계
    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Option> options = new HashSet<>();

    // 주문상품과의 관계
    @OneToMany(mappedBy = "product",cascade = CascadeType.REMOVE,orphanRemoval = true)
    private List<OrderProduct> products= new ArrayList<>();

    @Builder
    public Product( String productName, String productDesc, int price, String image) {
        this.productName = productName;
        this.productDesc = productDesc;
        this.price = price;
        this.image = image;
    }

}

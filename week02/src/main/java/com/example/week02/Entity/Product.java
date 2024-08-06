package com.example.week02.Entity;

//- product_id(pk)   상품 아이디
// - option_id(fk)
//- product_name     상품 이름
//- image            상품 사진
//- price            가격
//- description      상품 설명

import com.example.week02.Dtos.Option;
import com.example.week02.Dtos.OptionDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.*;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter

@Entity
@Table(name = "product_tb",uniqueConstraints = @UniqueConstraint(name = "uk_product_name",
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

    @Column(nullable = false)
    private int page;

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

    public static class ProductDto {

        // 상품 등록
        public class productRegist {
            private String productName;
            private String productDesc;
            private int price;
            private String image;

            public productRegist(String productName, String productDesc, int price, String image) {
                this.productName = productName;
                this.productDesc = productDesc;
                this.price = price;
                this.image = image;
            }
        }

        // 상품 검색
        public class productSearch {
            private String productName;
            private String productDesc;
            private String image;
            private Set<OptionDto> options; // OptionDto는 Option 엔티티를 대신할 DTO 클래스

            public productSearch(Product product) {
                this.productName = product.getProductName();
                this.productDesc = product.getProductDesc();
                this.image = product.getImage();
                this.options = product.getOptions().stream()
                        .map(option -> new OptionDto(option)) // OptionDto 클래스가 필요함
                        .collect(Collectors.toSet());
            }
        }

        // 상품 페이지 전체 조회
        public class productAllSearch {
            private String productName;
            private String productDesc;
            private String image;
            private int page; // 페이지 번호

            public productAllSearch(Product product, int page) {
                this.productName = product.getProductName();
                this.productDesc = product.getProductDesc();
                this.image = product.getImage();
                this.page = page;
            }
        }

        // 상품 수정
        public class productUpdate {
            private String productName;
            private String productDesc;
            private String image;
            private int price;

            public productUpdate(String productName, String productDesc, String image, int price) {
                this.productName = productName;
                this.productDesc = productDesc;
                this.image = image;
                this.price = price;
            }
        }

        // 상품 삭제
        @Getter
        public static class ProductDelete {
            private final String productName; // 상품 이름을 사용

            public ProductDelete(String productName) {
                this.productName = productName;
            }
        }

    }
}

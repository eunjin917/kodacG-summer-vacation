    package com.example.week02.Entity;

    //- option_id(pk)     옵션의 아이디
    //- option_name      옵션 이름(예 빨간색, OO추가)
    //- stock            재고 수량
    //- option_price   옵션가격

    import jakarta.persistence.*;
    import lombok.*;

    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Getter

    @Entity
    @Table(name = "option",
            uniqueConstraints = @UniqueConstraint(name =" uk_option_name",columnNames ="optionName"))
    public class Option {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int optionId;

        @Column(nullable = false)
        private String optionName;

        @Column(nullable = false)
        private int optionPrice;

        @Column(nullable = false)
        private int stock;

        // 상품과의 관계
        @ManyToOne(fetch = FetchType.LAZY)   // 지연로딩
        @JoinColumn(name = "product_id" ,nullable = false) // 외래키 설정
        private Product product;

        @Builder
        public Option(String optionName, int optionPrice, int stock) {
            this.optionName = optionName;
            this.optionPrice = optionPrice;
            this.stock = stock;
        }

    }

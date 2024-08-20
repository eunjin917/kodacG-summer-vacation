    package com.example.week02.Cart;

    //- cart_id(pk)    장바구니 번호
    //- order_product_id(fk)  주문상품 아이디 이걸로 유저 아이디 그냥 가져올 수 있을듯?
    //- cart_date       장바구니에 담은 일시
    //- total_price     총 금액

    import com.example.week02.Order.OrderProduct;
    import jakarta.persistence.*;
    import lombok.AccessLevel;
    import lombok.Getter;
    import lombok.NoArgsConstructor;

    import java.time.LocalDateTime;
    import java.util.*;

    import java.time.LocalDate;

    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Getter

    @Entity
    @Table(name = "cart")
    public class Cart {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int cartId;

        @Column(nullable = false)
        private LocalDate cartDate;

        @Column(nullable = false)
        private int total_price;

        // 주문상품과의 관계
        @OneToMany(mappedBy = "cart",cascade = CascadeType.REMOVE,orphanRemoval = true)
        private List<OrderProduct> items = new ArrayList<>();

        public Cart(int total_price, LocalDateTime cartDate){
            this.total_price = total_price;
            cartDate = LocalDateTime.now();
        }

    }

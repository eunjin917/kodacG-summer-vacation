package com.example.week02.Dtos;

import com.example.week02.Entity.Cart;
import com.example.week02.Entity.OrderProduct;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;


//- cart_id(pk)    장바구니 번호
//- order_product_id(fk)  주문상품 아이디 이걸로 유저 아이디 그냥 가져올 수 있을듯?
//- cart_date       장바구니에 담은 일시
//- total_price     총 금액

//- 장바구니 담기
//- 장바구니 조회
//- 장바구니 비우기

public class CartDto {

    // 장바구니 담기
    public record cartContain(int cartId, List<Integer> itemId, int totalPrice, LocalDateTime cartDate) {
        public cartContain(Cart cart){
            this(cart.getCartId(),
                    cart.getItems().stream().map(OrderProduct::getOrderProductId).collect(Collectors.toList()),
                    cart.getTotal_price(), LocalDateTime.now());
        }
    }

    // 장바구니 조회
    public record cartInfo(int cartId, List<Integer> itemId, int totalPrice, LocalDateTime cartDate){
        public cartInfo(Cart cart){
            this(cart.getCartId(),
                    cart.getItems().stream().map(OrderProduct :: getOrderProductId).collect(Collectors.toList()),
                    cart.getTotal_price(),
                    cart.getCartDate().atStartOfDay());
        }
    }
    // 장바구니 비우기
    public record cartDelete(int cartId){
        public cartDelete(Cart cart){
            this(cart.getCartId());

        }
    }
}

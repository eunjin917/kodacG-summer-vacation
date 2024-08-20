package com.example.week02.Cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    // 모든 장바구니 항목 조회
    @GetMapping
    public List<Cart> getAllCarts() {
        return cartService.getAllCarts();
    }

    // 특정 장바구니 항목 조회
    @GetMapping("/{id}")
    public Cart getCartById(@PathVariable String id) { // id 타입을 String으로 변경
        return cartService.getCartById(id);
    }

    // 새로운 장바구니 항목 생성
    @PostMapping
    public Cart createCart(@RequestBody Cart cart) {
        return cartService.createCart(cart);
    }

    // 특정 장바구니 항목 수정
    @PutMapping("/{id}")
    public Cart updateCart(@PathVariable String id, @RequestBody Cart cart) { // id 타입을 String으로 변경
        return cartService.updateCart(id, cart);
    }

    // 특정 장바구니 항목 삭제
    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable String id) { // id 타입을 String으로 변경
        cartService.deleteCart(id);
    }
}

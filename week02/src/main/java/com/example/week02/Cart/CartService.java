package com.example.week02.Cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Cart getCartById(String id) { // id를 String으로 변경 (Cart 엔티티에 맞게)
        return cartRepository.findById(id).orElse(null);
    }

    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public Cart updateCart(String id, Cart cart) {
        Cart existingCart = cartRepository.findById(id).orElse(null);
        if (existingCart != null) {
            // 기존 필드가 존재하지 않는 문제 해결을 위해 Cart 엔티티에 있는 필드로만 업데이트
            existingCart.setCart_date(cart.getCart_date());
            existingCart.setTotal_price(cart.getTotal_price());
            // 필요한 다른 필드 업데이트
            return cartRepository.save(existingCart);
        }
        return null;
    }

    public void deleteCart(String id) { // id를 String으로 변경 (Cart 엔티티에 맞게)
        cartRepository.deleteById(id);
    }
}

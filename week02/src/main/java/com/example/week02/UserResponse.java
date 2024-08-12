package com.example.week02;

import com.example.week02.cart.Cart;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

public class UserDTO {

    @Getter
    @Setter
    public static class UserResponse {
        private String userId;
        private String username;
        private String email;
        private String signDate;
        private List<CartDTO> carts;

        public UserResponse(User user) {
            this.userId = user.getUserId();
            this.username = user.getUsername();
            this.email = user.getEmail();
            this.signDate = user.getSignDate().toString();
            this.carts = user.getCarts().stream()
                    .map(CartDTO::new)
                    .collect(Collectors.toList());
        }
    }

    // DTO for Cart within User context
    @Getter
    @Setter
    public static class CartDTO {
        private String cartId;
        private String cartDate;
        private double totalPrice;

        public CartDTO(Cart cart) {
            this.cartId = cart.getCartId();
            this.cartDate = cart.getCartDate().toString();
            this.totalPrice = cart.getTotalPrice();
        }
    }
}

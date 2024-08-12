package com.example.week02.Cart;

import com.example.week02.Option.OptionDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

public class CartDTO {

    @Getter
    @Setter
    public static class CartResponse {
        private String cartId;
        private String cartDate;
        private double totalPrice;
        private List<CartProductDTO> products;

        public CartResponse(Cart cart) {
            this.cartId = cart.getCartId();
            this.cartDate = cart.getCartDate().toString();
            this.totalPrice = cart.getTotalPrice();
            this.products = cart.getCartProducts().stream()
                    .map(CartProductDTO::new)
                    .collect(Collectors.toList());
        }
    }

    @Getter
    @Setter
    public static class CartProductDTO {
        private String productId;
        private String productName;
        private int quantity;
        private double price;
        private OptionDTO option;

        public CartProductDTO(CartProduct cartProduct) {
            this.productId = cartProduct.getProduct().getProductId();
            this.productName = cartProduct.getProduct().getProductName();
            this.quantity = cartProduct.getQuantity();
            this.price = cartProduct.getPrice();
            this.option = new OptionDTO(cartProduct.getOption());
        }
    }
}

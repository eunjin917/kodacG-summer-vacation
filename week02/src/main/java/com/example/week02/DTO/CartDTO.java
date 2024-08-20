package com.example.week02.DTO;

import com.example.week02.ProductOption;
import com.example.week02.User;

public class CartDTO {
    private long id;
    private User user;
    private ProductOption option;
    private int price;
    private int quantity;

    public CartDTO(int id, User user, ProductOption option, int quantity, int price) {
        this.id = id;
        this.user = user;
        this.option = option;
        this.quantity = quantity;
        this.price = price;
    }
}

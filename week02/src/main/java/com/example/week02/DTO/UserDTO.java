package com.example.week02.DTO;


public class UserDTO {
    private long id;
    private String userId;
    private String userPassword;
    private String name;
    private int point;
    private String phoneNumber;
    private String email;
    private String deliveryAddress;

    public UserDTO(long id, String userId, String userPassword, String name, int point, String phoneNumber, String email, String deliveryAddress) {
        this.id = id;
        this.userId = userId;
        this.userPassword = userPassword;
        this.name = name;
        this.point = point;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.deliveryAddress = deliveryAddress;
    }
}
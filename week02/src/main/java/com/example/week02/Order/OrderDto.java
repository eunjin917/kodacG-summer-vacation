package com.example.week02.Order;

import java.time.*;



//  order_id(pk)     주문 번호
//- user_id(fk)      유저 아이디
//- order_date       주문 일시
//- delivery         배송지
//- delivery_status 배송 상태


public record OrderDto(

        long userId,
        long orderId,
        LocalDateTime orderDate,
        String delivery,
        String deliveryStatus)
{


    public OrderDto(Order order) {
        this(
                order.getUser().getUserId(),
                order.getOrderId(),
                order.getOrderDate(),
                order.getDelivery(),
                order.getDeliveryStatus());
        }
}




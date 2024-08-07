package com.example.week02.Dtos;

import com.example.week02.Entity.Order;
import lombok.Getter;

import java.time.*;

/*
- 주문 하기
- 주문 조회
- 주문 수정
- 주문 취소
- 배송 상태 조회
//  order_id(pk)     주문 번호
//- user_id(fk)      유저 아이디
//- order_date       주문 일시
//- delivery         배송지
//- delivery_status 배송 상태
*/
@Getter
public class OrderDto {

    // 주문하기
    @Getter
    public static class orderRegist{
        private final int userId;
        private final LocalDateTime orderDate;
        private final String delivery;
        private final String deliveryStatus;

        public orderRegist(Order order){
            userId = order.getUser().getUserId();
            orderDate = LocalDateTime.now();
            delivery = order.getDelivery();
            deliveryStatus = order.getDeliveryStatus();
        }

    }
    // 주문 조회 -- 이 기능은 그냥 order_product에 만드는 것이 나을 거 같은데
    // 주문 상품 dto가 가질 필드가 더 적절하다고 생각됨 다시 생각해보자 
    @Getter
    public static class orderDto{

        private final int userId;
        private final int orderId;
        private final LocalDateTime orderDate;
        private final String delivery;
        private final String deliveryStatus;

        public orderDto(Order order){
            userId = order.getUser().getUserId();
            orderId = order.getOrderId();
            orderDate = order.getOrderDate();
            delivery = order.getDelivery();
            deliveryStatus = order.getDeliveryStatus();

        }

    }
    // 주문 수정 엔티티의 원래 속성은 그대로 두고 변경하고자 하는 속성만 다르게
    @Getter
    public static class userUpdate{
        private final int userId;
        private final int orderId;
        private final LocalDateTime orderDate;
        private final String delivery;
        private final String deliveryStatus;

        public userUpdate(Order order,String delivery){
            userId = order.getUser().getUserId();
            orderId = order.getOrderId();
            orderDate = order.getOrderDate();
            this.delivery = delivery;
            deliveryStatus = order.getDeliveryStatus();
        }

    }
    // 주문 취소 취소하려는 주문의 유저 아이디와 주문번호를 가져옴
    @Getter
    public static class orderDelete{
        private final int userId;
        private final int orderId;

        public orderDelete(Order order){
            userId = order.getUser().getUserId();
            orderId = order.getOrderId();
        }
    }

    // 배송 상태 조회
    @Getter
    public static class orderStatus{
        private final String delivery;
        private final String status;

        public orderStatus(Order order){
            delivery = order.getDelivery();
            status  = order.getDeliveryStatus();
        }


    }



}

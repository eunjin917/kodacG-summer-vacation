package com.example.week02.Dtos;

//- payment_id(pk)     결제 아이디
//- order_product_id(fk) 주문상품 번호
//- payment_date       결제 일시
//- payment_method     결제 방식
//- payment_status     결제 상태

import com.example.week02.Entity.OrderProduct;
import com.example.week02.Entity.Payment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class PaymentDto {
    // 결제하기
    public record pay(int paymentId, List<Integer> itemId, LocalDateTime paymentDate, String method, String status){
        public pay(Payment payment){
            this(payment.getPaymentId(),
                    payment.getItem().stream().map(OrderProduct::getOrderProductId).collect(Collectors.toList()),
                    payment.getPaymentDate(),
                    payment.getPayment_method(),
                    payment.getPayment_status());
        }

    }
    // 결제 내역 조회
    public record payInfo(int paymentId, List<Integer> itemId, LocalDateTime paymentDate, String method, String status){
        public payInfo(Payment payment){
            this(payment.getPaymentId(),
                    payment.getItem().stream().map(OrderProduct::getOrderProductId).collect(Collectors.toList()),
                    payment.getPaymentDate(),
                    payment.getPayment_method(),
                    payment.getPayment_status());
        }

    }
    // 결제 세부사항 수정
    public record payUpdate(String method, String status){
        public payUpdate(Payment payment){
            this(payment.getPayment_method(), payment.getPayment_status());
        }

    }

    public record payDelete(int paymentId){
        public payDelete(Payment payment){
            this(payment.getPaymentId());
        }
    }
}

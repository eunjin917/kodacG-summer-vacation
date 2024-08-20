package com.example.week02.Payment;

import com.example.week02.Order.OrderProduct;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;



// 결제 내역 조회

public record PaymentDto(int paymentId,
                         List<Integer> itemId,
                         LocalDateTime paymentDate,
                         String method,
                         String status)
{
    public PaymentDto(Payment payment){
        this(payment.getPaymentId(),
                payment.getItem().stream().map(OrderProduct::getOrderProductId).collect(Collectors.toList()),
                payment.getPaymentDate(),
                payment.getPayment_method(),
                payment.getPayment_status());
    }

}



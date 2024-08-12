package com.example.week02;

import com.example.week02.OrderPay;
import com.example.week02.OrderProduct;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

public class OrderResponse {

    @Getter
    @Setter
    public static class OrderDTO {
        private String orderId;
        private int userId;
        private String orderDate;
        private String delivery;
        private double totalAmount;
        private String deliveryState;
        private List<OrderProductDTO> orderProducts;
        private List<OrderPayDTO> orderPayments;

        public OrderDTO(Order order) {
            this.orderId = order.getOrderId();
            this.userId = order.getUserId();
            this.orderDate = order.getOrderDate().toString();
            this.delivery = order.getDelivery();
            this.totalAmount = order.getTotalAmount();
            this.deliveryState = order.getDeliveryState();
            this.orderProducts = order.getOrderProducts().stream()
                    .map(OrderProductDTO::new).collect(Collectors.toList());
            this.orderPayments = order.getOrderPayments().stream()
                    .map(OrderPayDTO::new).collect(Collectors.toList());
        }
    }

    @Getter
    @Setter
    public static class OrderProductDTO {
        private String orderProductId;
        private String productId;
        private int quantity;
        private String optionId;
        private String optionDescription;

        public OrderProductDTO(OrderProduct orderProduct) {
            this.orderProductId = orderProduct.getOrderProductId();
            this.productId = orderProduct.getProductId();
            this.quantity = orderProduct.getQuantity();
            this.optionId = orderProduct.getOptionId();
            this.optionDescription = orderProduct.getOptionDescription();
        }
    }

    @Getter
    @Setter
    public static class OrderPayDTO {
        private String orderPayId;
        private String payId;
        private String payDate;
        private double amount;
        private String payMethod;
        private String payStatus;

        public OrderPayDTO(OrderPay orderPay) {
            this.orderPayId = orderPay.getOrderPayId();
            this.payId = orderPay.getPayId();
            this.payDate = orderPay.getPayDate().toString();
            this.amount = orderPay.getAmount();
            this.payMethod = orderPay.getPayMethod();
            this.payStatus = orderPay.getPayStatus();
        }
    }
}

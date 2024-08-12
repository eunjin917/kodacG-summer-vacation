package com.example.week02.Pay;

import com.example.week02.Order.OrderProduct;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class PaymentDTO {

    @Getter
    @Setter
    public static class Pay {
        private int paymentId;
        private List<Integer> itemId;
        private LocalDateTime paymentDate;
        private String method;
        private String status;

        public Pay(Payment payment) {
            this.paymentId = payment.getPaymentId();
            this.itemId = payment.getItem().stream()
                    .map(OrderProduct::getOrderProductId)
                    .collect(Collectors.toList());
            this.paymentDate = payment.getPaymentDate();
            this.method = payment.getPaymentMethod();
            this.status = payment.getPaymentStatus();
        }
    }

    @Getter
    @Setter
    public static class PayInfo {
        private int paymentId;
        private List<Integer> itemId;
        private LocalDateTime paymentDate;
        private String method;
        private String status;

        public PayInfo(Payment payment) {
            this.paymentId = payment.getPaymentId();
            this.itemId = payment.getItem().stream()
                    .map(OrderProduct::getOrderProductId)
                    .collect(Collectors.toList());
            this.paymentDate = payment.getPaymentDate();
            this.method = payment.getPaymentMethod();
            this.status = payment.getPaymentStatus();
        }
    }

    @Getter
    @Setter
    public static class PayUpdate {
        private int paymentId;
        private String method;
        private String status;

        public PayUpdate(Payment payment) {
            this.paymentId = payment.getPaymentId();
            this.method = payment.getPaymentMethod();
            this.status = payment.getPaymentStatus();
        }
    }

    @Getter
    @Setter
    public static class PayDelete {
        private int paymentId;

        public PayDelete(Payment payment) {
            this.paymentId = payment.getPaymentId();
        }
    }
}

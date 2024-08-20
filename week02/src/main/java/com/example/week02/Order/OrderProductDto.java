package com.example.week02.Order;

//- order_product_id(pk)
//- order_id(fk)          주문 번호
//- product_id(fk)        상품 아이디
//- quantity              주문 수량
//- total_price           총 주문 금액
//- option_description    옵션 설명


public record OrderProductDto(long orderId,
                              String productName,
                              String optionName,
                              int quantity,
                              int totalPrice)
    {
    public OrderProductDto(OrderProduct item){
        this(
                item.getOrder().getOrderId(),
                item.getProduct().getProductName(),
                item.getOptionDescription(),
                item.getQuantity(),
                item.getTotalPrice());
    }

}


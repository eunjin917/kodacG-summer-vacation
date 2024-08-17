package com.example.week02.Dtos;
import com.example.week02.Entity.OrderProduct;

//- order_product_id(pk)
//- order_id(fk)          주문 번호
//- product_id(fk)        상품 아이디
//- quantity              주문 수량
//- total_price           총 주문 금액
//- option_description    옵션 설명

// 주문 조회 기능 정도만 구현해도 될거 같은데 ?
// 옵션.


public class OrderProductDto {

    public record orderProductInfo(int orderId, String productName, String optionName,int quantity,int totalPrice)    {
        public orderProductInfo(OrderProduct item){
            this(item.getOrder().getOrderId(), item.getProduct().getProductName(),item.getOptionDescription(),
                    item.getQuantity(), item.getTotalPrice());
        }

    }
}

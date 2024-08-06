package com.example.week02.Dtos;

import java.time.*;

/*
- 주문 하기
- 주문 조회
- 주문 수정
- 주문 취소
- 배송 상태 조회
*/

public class OrderData {

    public record orderRegister(String delivery, int total_amount, String deliveryStatus, LocalDateTime orderDate){
        // 주문하기 기능
    }

    // 주문 조회하기
    // 레코드 말고 외부 클래스로 만들어서 유저 이름과 주문, 그리고 어떤 상품이 들어갔는지를 조회가 가능해야 할거 같은데 ...

    // 주문 수정하기
    // 배송지 및 주문한 상품을 수정하는 경우가 발생할 거 같은데,,, 이것도 외부에서 좀 order_product에 관한 것들을 좀 받아오는게...

    // 주문 삭제하기
    // 주문 삭제도 유저가 삭제할 주문을 찾아야 함


}

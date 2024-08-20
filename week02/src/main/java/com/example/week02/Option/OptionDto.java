package com.example.week02.Option;

import lombok.Getter;
//- 옵션 등록
//- 옵션 수정
//- 옵션 삭제

@Getter
public class OptionDto {

    private String optionName;
    private int optionPrice;
    private int stock;

    // Option 객체를 매개변수로 받는 생성자, 상품 조회시 사용됨
    public OptionDto(Option option) {
        this.optionName = option.getOptionName();
        this.optionPrice = option.getOptionPrice();
        this.stock = option.getStock();
    }


}

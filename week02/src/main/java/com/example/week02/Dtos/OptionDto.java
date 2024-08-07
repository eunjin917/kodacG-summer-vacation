package com.example.week02.Dtos;

import com.example.week02.Entity.Option;
import lombok.Getter;
//- 옵션 등록
//- 옵션 수정
//- 옵션 삭제

@Getter
public class OptionDto {

    private String optionName;
    private int optionPrice;
    private int stock;

    // Option 객체를 매개변수로 받는 생성자
    public OptionDto(Option option) {
        this.optionName = option.getOptionName();
        this.optionPrice = option.getOptionPrice();
        this.stock = option.getStock();
    }

    // 옵션 등록, 이미 만들어진 엔티티 객체가 있다면 그것으로 매개변수로 받아도 될듯
    @Getter
    public static class OptionRegist {
        private final String optionName;
        private final int optionPrice;
        private final int stock;

        public OptionRegist(String optionName, int optionPrice, int stock) {
            this.optionName = optionName;
            this.optionPrice = optionPrice;
            this.stock = stock;
        }
    }

    // 옵션 수정, 수정할 내용을 매개변수로
    @Getter
    public static class OptionUpdate {
        private final String optionName;
        private final int optionPrice;
        private final int stock;

        public OptionUpdate(String optionName, int optionPrice, int stock) {
            this.optionName = optionName;
            this.optionPrice = optionPrice;
            this.stock = stock;
        }
    }

    // 옵션 삭제
    @Getter
    public static class OptionDelete {
        private final String optionName;
        private final String productName;

        public OptionDelete(String optionName, String productName) {
            this.optionName = optionName;
            this.productName = productName;
        }
    }
}

package com.example.week02.Dtos;

import lombok.Getter;


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

    // 옵션 등록
    @Getter
    public static class OptionRegist {
        private String optionName;
        private int optionPrice;
        private int stock;

        public OptionRegist(String optionName, int optionPrice, int stock) {
            this.optionName = optionName;
            this.optionPrice = optionPrice;
            this.stock = stock;
        }
    }

    // 옵션 수정
    @Getter
    public static class OptionUpdate {
        private String optionName;
        private int optionPrice;
        private int stock;

        public OptionUpdate(String optionName, int optionPrice, int stock) {
            this.optionName = optionName;
            this.optionPrice = optionPrice;
            this.stock = stock;
        }
    }

    // 옵션 삭제
    @Getter
    public static class OptionDelete {
        private String optionName;
        private String productName;

        public OptionDelete(String optionName, String productName) {
            this.optionName = optionName;
            this.productName = productName;
        }
    }
}

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

    // Option 객체를 매개변수로 받는 생성자, 상품 조회시 사용됨
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
        private final int optionId;
        private final String optionName;
        private final int optionPrice;
        private final int stock;

        public OptionUpdate(int optionId, String optionName, int optionPrice, int stock) {
            this.optionId = optionId;
            this.optionName = optionName;
            this.optionPrice = optionPrice;
            this.stock = stock;
        }
    }

    // 옵션 삭제
    @Getter
    public static class OptionDelete {
        private final int optionId;

        public OptionDelete(int optionId) {
            this.optionId = optionId;
        }
    }
    // 옵션 등록
    public record registOption(String optionName,int optionPrice, int stock){
        public registOption(Option option){
            this(option.getOptionName(), option.getOptionPrice(),option.getStock());
        }
    }
    // 옵션 수정
    public record updateOption(int optionId, String optionName,int optionPrice, int stock){
        public updateOption(Option option){
            this(option.getOptionId(),option.getOptionName(), option.getOptionPrice(),option.getStock());
        }
    }
    // 옵션 삭제
    public record deleteOption(int optionId){
        public deleteOption(Option option){
            this(option.getOptionId());
        }
    }
}

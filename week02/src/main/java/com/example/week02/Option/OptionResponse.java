package com.example.week02.Option;

import lombok.Getter;
import lombok.Setter;

public class OptionDTO {

    @Getter
    @Setter
    public static class OptionResponse {
        private String optionId;
        private String optionName;
        private double additionalPrice;

        public OptionResponse(Option option) {
            this.optionId = option.getOptionId();
            this.optionName = option.getOptionName();
            this.additionalPrice = option.getAdditionalPrice();
        }
    }
}

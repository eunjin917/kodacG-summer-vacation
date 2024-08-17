package com.example.week02.Dtos;

import com.example.week02.Entity.Product;
import lombok.Getter;

import java.util.Set;
import java.util.stream.Collectors;


public class ProductDto {

    // 상품 검색
    public record searchProduct(
            int productId,
            String productName,
            String productDesc,
            String image,
            Set<OptionDto> options) {


        public searchProduct(Product product) {
            this(
                    product.getProductId(),
                    product.getProductName(),
                    product.getProductDesc(),
                    product.getImage(),
                    product.getOptions().stream()
                            .map(OptionDto::new) // 중복되는 옵션을 제거
                            .collect(Collectors.toSet())
            );
        }


        public String toString() {
            return "productId :" + productId + "\n" +
                    "productName :" + productName + "\n" +
                    "productDesc :" + productDesc + "\n" +
                    "image :" + image + "\n" +
                    "options :" + options;
        }
    }
}


// 일단은 저렇게만 구성해두자

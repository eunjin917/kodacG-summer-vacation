package com.example.week02.Product;

import com.example.week02.Option.OptionDto;

import java.util.Set;
import java.util.stream.Collectors;


// 조회
public record ProductDto(
        int productId,
        String productName,
        String productDesc,
        String image,
        Set<OptionDto> options) {


     public ProductDto(Product product) {
         this(
                 product.getProductId(),
                 product.getProductName(),
                 product.getProductDesc(),
                 product.getImage(),
                 product.getOptions().stream()
                         .map(OptionDto::new)
                         .collect(Collectors.toSet()));
        }

    }

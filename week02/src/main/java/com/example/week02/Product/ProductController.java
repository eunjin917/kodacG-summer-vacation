package com.example.week02.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService; // 서비스에서 엔티티를 Dto로 가공하도록


    @GetMapping("/products/{product_id}") // 특정 상품을 조회

    public ProductDto productResponse(@PathVariable("product_id") long product_id) {
        return  productService.toConvertDto(productService.searchProduct(product_id));

    }

    // 페이지네이션된 상품 목록 조회
    @GetMapping("/products")
    public Page<ProductDto> getProducts(
            @RequestParam(defaultValue = "0") int page) {
        return productService.getProducts(page);
    }


}



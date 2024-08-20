package com.example.week02.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // 서비스에서 로직을 구현하는 방식이 궁금함
    // 컨트롤러에서 필요한 리포지터리의 메소드를 정리하여 둔다고 생각하면 편함

    // 특정 상품을 조회
    // 우리가 전달하는 것은 번호
    public Product searchProduct(int id){
        Optional<Product> oq = productRepository.findById(id);
        if(oq.isPresent()){
            return oq.get();
        }else throw new DataNotFoundException("product not found");


        // optional을 사용하는 이유가 null 값을 유연하게 처리하기 위함
        // 조회하고자 하는 아이디의 상품이 존재하지 않을 경우에 아래 예외처리문 실행

    }
    // 페이지네이션된 상품 조회
    public Page<ProductDto> getProducts(int page) {
        Pageable pageable = PageRequest.of(page, 10); // 페이지 크기를 고정
        Page<Product> productPage = productRepository.findAll(pageable);
        return productPage.map(this::toConvertDto); // DTO로 변환하여 반환
    }

    public ProductDto toConvertDto(Product entity){
        ProductDto pro = new ProductDto(entity); // Dto 객체를 생성하고 엔티티를 넘겨줌
        return pro;
    }
}



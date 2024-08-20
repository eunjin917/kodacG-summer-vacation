package com.example.week02.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    // findById, findAll 메소드는 그냥 제공
    // 새로운 메소드는 규칙에 맞추어서 설계해야함
    // 상품 조회에 대한 서비스에서 구현할 로직은, 특정 아이디를 가지는 상품을 조회하기,
    // 전체 상품 즉 여러개 상품을 조회하는 것. 그렇다면 서비스에서 리포지터리 선언 후, 가져오기

}

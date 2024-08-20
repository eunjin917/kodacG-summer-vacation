package com.example.week02;
import com.example.week02.Entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    // 풀리퀘 확인
}

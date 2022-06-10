package com.example.hellohotel.HelloHotel.domain.service;

import com.example.hellohotel.HelloHotel.domain.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Page<Product> getAll(Pageable pageable);
    Product getById(Long studentId);
    Product create(Product product);
    Product update(Long studentId, Product request);
    ResponseEntity<?> delete(Long product_Id);
}

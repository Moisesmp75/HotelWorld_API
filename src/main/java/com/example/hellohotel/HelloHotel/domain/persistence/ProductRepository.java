package com.example.hellohotel.HelloHotel.domain.persistence;

import com.example.hellohotel.HelloHotel.domain.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByProductId(Long id);
    Page<Product> findByProductId(Long ProductId, Pageable pageable);
    List<Product> findByProductName(String Name);
}

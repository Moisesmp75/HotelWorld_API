package com.example.hellohotel.HelloHotel.service;

import com.example.hellohotel.HelloHotel.domain.model.entity.Hotel;
import com.example.hellohotel.HelloHotel.domain.model.entity.Product;
import com.example.hellohotel.HelloHotel.domain.persistence.HotelRepository;
import com.example.hellohotel.HelloHotel.domain.persistence.ProductRepository;
import com.example.hellohotel.HelloHotel.domain.service.ProductService;
import com.example.hellohotel.shared.exception.ResourceNotFoundException;
import com.example.hellohotel.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServicelpml implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> getAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product getById(Long studentId) {
        return productRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Hotel","Id",studentId));
    }

    @Override
    public Product create(Product product) {
        Optional<Product> product1 = productRepository.findById(product.getId());
        if(product1!=null){
            throw new ResourceValidationException("Product","An Product with same name exist alredy");
        }
        return productRepository.save(product);
    }

    @Override
    public Product update(Long productId, Product request) {
        Product product1 = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Hotel", "Id", productId));

        return productRepository.findById(productId).map(hotel ->
                        productRepository.save(hotel.withName(request.getName())
                                .withDescription(request.getDescription())
                                .withStock(request.getStock())))
                .orElseThrow(()-> new ResourceNotFoundException("Hotel","Id",productId));
    }

    @Override
    public ResponseEntity<?> delete(Long product_Id) {
        return productRepository.findById(product_Id).map(hotel -> {
            productRepository.delete(hotel);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Hotel","Id",product_Id));

    }
}

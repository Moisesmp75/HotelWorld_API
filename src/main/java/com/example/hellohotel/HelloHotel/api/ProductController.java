package com.example.hellohotel.HelloHotel.api;

import com.example.hellohotel.HelloHotel.domain.service.ProductService;
import com.example.hellohotel.HelloHotel.mapping.ProductMapper;
import com.example.hellohotel.HelloHotel.resource.CreateProductResource;
import com.example.hellohotel.HelloHotel.resource.UpdateProductResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public class ProductController {
    private final ProductService productService;
    private final ProductMapper mapper;

    public ProductController(ProductService productService, ProductMapper mapper) {
        this.productService = productService;
        this.mapper = mapper;
    }
    @GetMapping
    public Page<ProductMapper> getAllProducts(Pageable pageable) {
        return mapper.modelListPage(productService.getAll(), pageable);
    }

    @GetMapping("{skillId}")
    public ProductMapper getSkillById(@PathVariable Long skillId) {
        return mapper.toResource(productService.getById(skillId));
    }

    @PostMapping
    public ProductMapper createProduct(@RequestBody CreateProductResource resource) {
        return mapper.toResource(productService.create(mapper.toModel(resource)));
    }

    @PutMapping("{product_Id}")
    public ProductMapper updateProduct(@PathVariable Long skillId, @RequestBody UpdateProductResource resource) {
        return mapper.toResource(productService.update(skillId, mapper.toModel(resource)));
    }

    @DeleteMapping("{product_Id}")
    public ResponseEntity<?> deleteSkill(@PathVariable Long skillId) {
        return productService.delete(skillId);
    }

}

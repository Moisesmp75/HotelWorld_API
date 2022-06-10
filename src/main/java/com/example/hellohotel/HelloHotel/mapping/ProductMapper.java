package com.example.hellohotel.HelloHotel.mapping;

import com.example.hellohotel.HelloHotel.domain.model.entity.Product;
import com.example.hellohotel.HelloHotel.resource.CreateProductResource;
import com.example.hellohotel.HelloHotel.resource.UpdateProductResource;
import com.example.hellohotel.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class ProductMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    // Object Mapping
    public ProductMapper toResource(Product model) {
        return mapper.map(model, ProductMapper.class);
    }

    public Page<ProductMapper> modelListPage(List<Product> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ProductMapper.class), pageable, modelList.size());
    }

    public Product toModel(CreateProductResource resource) {
        return mapper.map(resource, Product.class);
    }

    public Product toModel(UpdateProductResource resource) {
        return mapper.map(resource, Product.class);
    }
}

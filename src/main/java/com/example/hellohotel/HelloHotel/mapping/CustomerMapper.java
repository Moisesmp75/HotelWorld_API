package com.example.hellohotel.HelloHotel.mapping;

import com.example.hellohotel.HelloHotel.domain.model.entity.Customer;
import com.example.hellohotel.HelloHotel.resource.CreateCustomerResource;
import com.example.hellohotel.HelloHotel.resource.CustomerResource;
import com.example.hellohotel.HelloHotel.resource.UpdateCustomerResource;
import com.example.hellohotel.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;


public class CustomerMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    // Object Mapping
    public CustomerResource toResource(Customer model) {
        return mapper.map(model, CustomerResource.class);
    }

    public Page<CustomerResource> modelListPage(List<Customer> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, CustomerResource.class), pageable, modelList.size());
    }

    public Customer toModel(CreateCustomerResource resource) {
        return mapper.map(resource, Customer.class);
    }

    public Customer toModel(UpdateCustomerResource resource) {
        return mapper.map(resource, Customer.class);
    }
}

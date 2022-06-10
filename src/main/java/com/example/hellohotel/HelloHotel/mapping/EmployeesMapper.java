package com.example.hellohotel.HelloHotel.mapping;

import com.example.hellohotel.HelloHotel.domain.model.entity.Employees;
import com.example.hellohotel.HelloHotel.resource.CreateEmployeeResource;
import com.example.hellohotel.HelloHotel.resource.EmployeesResource;
import com.example.hellohotel.HelloHotel.resource.UpdateEmployeesResource;
import com.example.hellohotel.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.Mapping;

import java.io.Serializable;
import java.util.List;


public class EmployeesMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    // Object Mapping
    public EmployeesResource toResource(Employees model) {
        return mapper.map(model, EmployeesResource.class);
    }

    public Page<EmployeesResource> modelListPage(List<Employees> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, EmployeesResource.class), pageable, modelList.size());
    }

    public Employees toModel(CreateEmployeeResource resource) {
        return mapper.map(resource, Employees.class);
    }

    public Employees toModel(UpdateEmployeesResource resource) {
        return mapper.map(resource, Employees.class);
    }
}

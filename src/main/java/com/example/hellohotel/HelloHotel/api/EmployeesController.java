package com.example.hellohotel.HelloHotel.api;

import com.example.hellohotel.HelloHotel.domain.service.EmployeeService;
import com.example.hellohotel.HelloHotel.mapping.EmployeesMapper;
import com.example.hellohotel.HelloHotel.resource.CreateEmployeeResource;
import com.example.hellohotel.HelloHotel.resource.EmployeesResource;
import com.example.hellohotel.HelloHotel.resource.UpdateEmployeesResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public class EmployeesController {
    private final EmployeeService employeeService;
    private final EmployeesMapper mapper;

    public EmployeesController(EmployeeService employeeService, EmployeesMapper mapper) {
        this.employeeService = employeeService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<EmployeesResource> getEmployees(Pageable pageable) {
        return mapper.modelListPage(employeeService.getAll(), pageable);
    }

    @GetMapping("{Employee_Id}")
    public EmployeesResource getEmployeeById(@PathVariable Long skillId) {
        return mapper.toResource(employeeService.getById(skillId));
    }

    @PostMapping
    public EmployeesResource createEmployee(@RequestBody CreateEmployeeResource resource) {
        return mapper.toResource(employeeService.create(mapper.toModel(resource)));
    }

    @PutMapping("{skillId}")
    public EmployeesResource updateEmployee(@PathVariable Long skillId, @RequestBody UpdateEmployeesResource resource) {
        return mapper.toResource(employeeService.update(skillId, mapper.toModel(resource)));
    }

    @DeleteMapping("{skillId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long skillId) {
        return employeeService.delete(skillId);
    }
}

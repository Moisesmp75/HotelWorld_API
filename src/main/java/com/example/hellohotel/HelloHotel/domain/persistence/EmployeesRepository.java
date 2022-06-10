package com.example.hellohotel.HelloHotel.domain.persistence;

import com.example.hellohotel.HelloHotel.domain.model.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeesRepository extends JpaRepository<Employees,Long> {
    List<Employees> findAllById(Long id);
    List<Employees> findByName(String name);
}

package com.example.hellohotel.HelloHotel.domain.persistence;

import com.example.hellohotel.HelloHotel.domain.model.entity.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByHotelId(Long HotelID);
    public Optional<Hotel> findByName(String Name);
    Page<Hotel> findAll(Pageable pageable);
}

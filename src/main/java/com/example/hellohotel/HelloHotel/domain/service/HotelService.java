package com.example.hellohotel.HelloHotel.domain.service;

import com.example.hellohotel.HelloHotel.domain.model.entity.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.awt.print.Pageable;
import java.util.List;

public interface HotelService {
    List<Hotel> getAllHotels();
    Page<Hotel> getAll(Pageable pageable);
    Hotel getById(Long HotelId);
    Hotel create(Hotel hotel);
    Hotel update(Long hotel_id, Hotel request);
    ResponseEntity<?> delete(Long HotelId);
}

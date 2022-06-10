package com.example.hellohotel.HelloHotel.service;
import com.example.hellohotel.HelloHotel.domain.model.entity.Hotel;
import com.example.hellohotel.HelloHotel.domain.persistence.HotelRepository;
import com.example.hellohotel.HelloHotel.domain.service.HotelService;
import com.example.hellohotel.shared.exception.ResourceNotFoundException;
import com.example.hellohotel.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class HotelServicelmpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Page<Hotel> getAll(Pageable pageable) {
        return hotelRepository.findAll(pageable);
    }

    @Override
    public Hotel getById(Long HotelId) {
        return hotelRepository.findById(HotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel","Id",HotelId));
    }

    @Override
    public Hotel create(Hotel hotel) {
        Optional<Hotel> hotel1 = hotelRepository.findByName(hotel.getName());
        if(hotel1!=null){
            throw new ResourceValidationException("Hotel","An Hotel with same name exist alredy");
        }
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel update(Long hotel_id, Hotel request) {
        Hotel hotel1 = hotelRepository.findById(hotel_id).orElseThrow(() -> new ResourceNotFoundException("Hotel", "Id", hotel_id));

        return hotelRepository.findById(hotel_id).map(hotel ->
                hotelRepository.save(hotel.withName(request.getName())
                        .withDescription(request.getDescription())
                        .withLocation(request.getLocation())))
                .orElseThrow(()-> new ResourceNotFoundException("Hotel","Id",hotel_id));

    }

    @Override
    public ResponseEntity<?> delete(Long HotelId) {
        return hotelRepository.findById(HotelId).map(hotel -> {
            hotelRepository.delete(hotel);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Hotel","Id",HotelId));
    }
}

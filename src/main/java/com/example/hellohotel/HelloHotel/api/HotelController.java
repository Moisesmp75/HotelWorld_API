package com.example.hellohotel.HelloHotel.api;
import com.example.hellohotel.HelloHotel.domain.service.HotelService;
import com.example.hellohotel.HelloHotel.mapping.HotelMapper;
import com.example.hellohotel.HelloHotel.resource.CreateHotelResource;
import com.example.hellohotel.HelloHotel.resource.HotelResource;
import com.example.hellohotel.HelloHotel.resource.UpdateHotelResource;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;


public class HotelController {
    private final HotelService hotelService;
    private final HotelMapper mapper;


    public HotelController(HotelService hotelService, HotelMapper mapper) {
        this.hotelService = hotelService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<HotelResource> getAllHotels(Pageable pageable) {
        return mapper.modelListPage(hotelService.getAllHotels(), pageable);
    }

    @GetMapping("hotelId")
    public HotelMapper getHotelById(@PathVariable Long HotelId){
        return mapper.toResource(hotelService.getById(HotelId));
    }

    @GetMapping
    public HotelMapper createHotel(@RequestBody CreateHotelResource resource){
        return mapper.toResource(hotelService.create(mapper.toModel(resource)));
    }

    @GetMapping("hotelId")
    public HotelMapper updateHotel(@PathVariable Long HotelId, @RequestBody UpdateHotelResource resource){
        return mapper.toResource(hotelService.update(HotelId,mapper.toModel(resource)));
    }

    @GetMapping("{hotelId}")
    public ResponseEntity<?> deleteHotel(@PathVariable Long hotelId){
        return hotelService.delete(hotelId);
    }

}

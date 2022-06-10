package com.example.hellohotel.HelloHotel.service;

import com.example.hellohotel.HelloHotel.domain.model.entity.Hotel;
import com.example.hellohotel.HelloHotel.domain.model.entity.room;
import com.example.hellohotel.HelloHotel.domain.persistence.HotelRepository;
import com.example.hellohotel.HelloHotel.domain.persistence.RoomRepository;
import com.example.hellohotel.HelloHotel.domain.service.RoomService;
import com.example.hellohotel.shared.exception.ResourceNotFoundException;
import com.example.hellohotel.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class RoomServicelpml implements RoomService {
    @Autowired
    private RoomRepository roomRepository;


    @Override
    public List<room> getAll() {return roomRepository.findAll();}
    @Override
    public Page<room> getAll(Pageable pageable){
        return roomRepository.findAll((org.springframework.data.domain.Pageable) pageable);
    }

    @Override
    public room getById(Long room_Id) {
        return roomRepository.findById(room_Id).orElseThrow(() -> new ResourceNotFoundException("Hotel","Id",room_Id));
    }

    @Override
    public room create(room room) {
        Optional<room> room1 = roomRepository.findByRoomNumber(room.getRoomNumber());
        if(room1 != null){
            throw new ResourceValidationException("room","An room with same name exist alredy");
        }
        return roomRepository.save(room);
    }

    @Override
    public room Update(Long id, room request) {
        room room1 = roomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel", "Id", id));

        return roomRepository.findById(id).map(hotel ->
                        roomRepository.save(hotel.withState(request.getState())
                                .withDescription(request.getDescription())
                                .withBeds(request.getBeds())))
                .orElseThrow(()-> new ResourceNotFoundException("Hotel","Id",id));
    }

    @Override
    public ResponseEntity<?> delete(Long roomId) {
        return roomRepository.findById(roomId).map(hotel -> {
            roomRepository.delete(hotel);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Hotel","Id",roomId));
    }
}

package com.example.hellohotel.HelloHotel.domain.service;

import com.example.hellohotel.HelloHotel.domain.model.entity.room;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.awt.print.Pageable;
import java.util.List;

public interface RoomService {
    List<room> getAll();
    Page<room> getAll(Pageable pageable);
    room getById(Long room_Id);
    room create(room room);
    room Update(Long id, room request);
    ResponseEntity<?> delete(Long roomId);

}

package com.example.hellohotel.HelloHotel.api;

import com.example.hellohotel.HelloHotel.domain.service.RoomService;
import com.example.hellohotel.HelloHotel.mapping.RoomMapper;
import com.example.hellohotel.HelloHotel.resource.CreateRoomResource;
import com.example.hellohotel.HelloHotel.resource.ProductResource;
import com.example.hellohotel.HelloHotel.resource.RoomResource;
import com.example.hellohotel.HelloHotel.resource.UpdateRoomResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public class RoomController {
    private final RoomService roomService;

    private final RoomMapper mapper;

    public RoomController(RoomService roomService, RoomMapper mapper) {
        this.roomService = roomService;
        this.mapper = mapper;
    }


    @GetMapping
    public Page<RoomResource> getAllRooms(Pageable pageable) {
        return mapper.modelListPage(roomService.getAll(),pageable);
    }

    @GetMapping("{skillId}")
    public RoomResource getRoomById(@PathVariable Long skillId) {
        return mapper.toResource(roomService.getById(skillId));
    }

    @PostMapping
    public RoomResource CreateRoom(@RequestBody CreateRoomResource resource) {
        return mapper.toResource(roomService.create(mapper.toModel(resource)));
    }

    @PutMapping("{skillId}")
    public RoomResource updateRoom(@PathVariable Long skillId, @RequestBody UpdateRoomResource resource) {
        return mapper.toResource(roomService.Update(skillId, mapper.toModel(resource)));
    }

    @DeleteMapping("{skillId}")
    public ResponseEntity<?> deleteRooml(@PathVariable Long skillId) {
        return roomService.delete(skillId);
    }
}

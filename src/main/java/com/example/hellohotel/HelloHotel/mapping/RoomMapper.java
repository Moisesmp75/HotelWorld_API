package com.example.hellohotel.HelloHotel.mapping;

import com.example.hellohotel.HelloHotel.domain.model.entity.room;
import com.example.hellohotel.HelloHotel.resource.CreateRoomResource;
import com.example.hellohotel.HelloHotel.resource.ProductResource;
import com.example.hellohotel.HelloHotel.resource.RoomResource;
import com.example.hellohotel.HelloHotel.resource.UpdateRoomResource;
import com.example.hellohotel.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;


public class RoomMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    // Object Mapping
    public RoomResource toResource(room model) {
        return mapper.map(model, RoomResource.class);
    }

    public Page<RoomResource> modelListPage(List<room> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, RoomResource.class), pageable, modelList.size());
    }

    public room toModel(CreateRoomResource resource) {
        return mapper.map(resource, room.class);
    }

    public room toModel(UpdateRoomResource resource) {
        return mapper.map(resource, room.class);
    }


}

package com.example.hellohotel.HelloHotel.mapping;

import com.example.hellohotel.HelloHotel.resource.CreateHotelResource;
import com.example.hellohotel.HelloHotel.resource.HotelResource;
import com.example.hellohotel.HelloHotel.resource.UpdateHotelResource;
import com.example.hellohotel.HelloHotel.domain.model.entity.Hotel;
import com.example.hellohotel.shared.mapping.EnhancedModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.awt.print.Pageable;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

public class HotelMapper implements Serializable {

    EnhancedModelMapper mapper;

    public HotelMapper toResource(Hotel model) {
        return mapper.map((Object) model, (Type) HotelResource.class);
    }

    public Page<HotelResource> modelListPage(List<Hotel> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList,HotelResource.class),
                (org.springframework.data.domain.Pageable) pageable,modelList.size());
    }

    public Hotel toModel(CreateHotelResource resource){return mapper.map(resource,Hotel.class);}
    public Hotel toModel(UpdateHotelResource resource){return mapper.map(resource,Hotel.class);}
}























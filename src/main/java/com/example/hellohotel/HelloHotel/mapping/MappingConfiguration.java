package com.example.hellohotel.HelloHotel.mapping;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("HelloHotelMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public HotelMapper hotelMapper(){return new HotelMapper();}
}

package com.example.hellohotel.HelloHotel.resource;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateProductResource {
    @NotBlank
    @NotNull
    private Long stock;
}

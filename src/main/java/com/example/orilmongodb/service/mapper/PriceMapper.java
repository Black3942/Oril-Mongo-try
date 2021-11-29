package com.example.orilmongodb.service.mapper;

import com.example.orilmongodb.dto.PriceRequestDto;
import com.example.orilmongodb.dto.PriceResponseDto;
import com.example.orilmongodb.model.Price;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class PriceMapper {
    public Price requestDtoToModel(PriceRequestDto dto) {
        Price price = new Price();
        price.setLprice(dto.getLprice());
        price.setCurr1(dto.getCurr1());
        price.setCreatedAt(LocalDateTime.now());
        return price;
    }

    public PriceResponseDto modelToResponseDto(Price price) {
        PriceResponseDto dto = new PriceResponseDto();
        dto.setLprice(price.getLprice());
        dto.setCurr1(price.getCurr1());
        dto.setCreatedAt(price.getCreatedAt());
        return dto;
    }
}

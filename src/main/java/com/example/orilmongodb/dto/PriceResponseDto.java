package com.example.orilmongodb.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class PriceResponseDto {
    private Double lprice;
    private String curr1;
    private LocalDateTime createdAt;
}

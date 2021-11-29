package com.example.orilmongodb.model;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Price {
    private String id;
    private Double lprice;
    private String curr1;
    private LocalDateTime createdAt;
}

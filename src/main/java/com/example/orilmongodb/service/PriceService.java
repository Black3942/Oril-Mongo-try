package com.example.orilmongodb.service;

import com.example.orilmongodb.model.Price;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PriceService {
    Double getMin(String curr1);

    Double getMax(String curr1);

    Page<Price> getAllByName(String curr1, Pageable pageable);

    List<Price> getAll();
}

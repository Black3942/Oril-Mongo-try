package com.example.orilmongodb.service.impl;

import com.example.orilmongodb.model.Price;
import com.example.orilmongodb.repository.PriceRepository;
import com.example.orilmongodb.service.PriceService;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepository repository;

    public PriceServiceImpl(PriceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Double getMin(String curr1) {
        return repository.findByCurr1(curr1)
                .stream()
                .mapToDouble(Price::getLprice)
                .min()
                .orElseThrow();
    }

    @Override
    public Double getMax(String curr1) {
        return repository.findByCurr1(curr1)
                .stream()
                .mapToDouble(Price::getLprice)
                .max()
                .orElseThrow();
    }

    @Override
    public Page<Price> getAllByName(String curr1, Pageable pageable) {
        return repository.findByCurr1And(curr1, pageable);
    }

    @Override
    public List<Price> getAll() {
        return repository.findAll();
    }
}

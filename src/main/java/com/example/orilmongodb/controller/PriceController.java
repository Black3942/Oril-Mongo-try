package com.example.orilmongodb.controller;

import com.example.orilmongodb.dto.PriceResponseDto;
import com.example.orilmongodb.model.Price;
import com.example.orilmongodb.service.CsvWriter;
import com.example.orilmongodb.service.PriceService;
import com.example.orilmongodb.service.mapper.PriceMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cryptocurrencies")
public class PriceController {
    private final PriceService priceService;
    private final PriceMapper mapper;

    public PriceController(PriceService priceService, PriceMapper mapper) {
        this.priceService = priceService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<Price> get(@RequestParam String name,
                           @RequestParam(required = false, defaultValue = "0") Integer page,
                           @RequestParam(required = false, defaultValue = "10") Integer size) {
        Pageable pageable = PageRequest.of(page, size,  Sort.by("lprice"));
        return priceService.getAllByName(name, pageable);
    }

    @GetMapping("/all")
    public List<PriceResponseDto> getAll() {
        List<PriceResponseDto> result = new ArrayList<>();
        List<Price> all = priceService.getAll();
        all.forEach(p -> result.add(mapper.modelToResponseDto(p)));
        return result;
    }

    @GetMapping("/minprice")
    public Double min(@RequestParam String name) {
        return priceService.getMin(name);
    }

    @GetMapping("/maxprice")
    public Double max(@RequestParam String name) {
        return priceService.getMax(name);
    }

    @GetMapping("/csv")
    public void csv() {
        List<String> list = List.of("BTC", "ETH", "XRP");
        list.forEach(e -> CsvWriter.writeData(list, priceService.getMin(e), priceService.getMax(e)));
    }
}

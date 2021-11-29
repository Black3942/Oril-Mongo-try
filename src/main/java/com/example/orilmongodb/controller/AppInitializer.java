package com.example.orilmongodb.controller;

import com.example.orilmongodb.config.DataSourceConfig;
import com.example.orilmongodb.repository.PriceRepository;
import com.example.orilmongodb.service.PriceHttpClient;
import com.example.orilmongodb.service.mapper.PriceMapper;
import javax.annotation.PostConstruct;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AppInitializer {
    private final DataSourceConfig config;
    private final PriceHttpClient httpClient;
    private final PriceRepository priceRepository;
    private final PriceMapper mapper;

    public AppInitializer(DataSourceConfig config, PriceHttpClient httpClient,
                          PriceRepository priceRepository, PriceMapper mapper) {
        this.config = config;
        this.httpClient = httpClient;
        this.priceRepository = priceRepository;
        this.mapper = mapper;
    }

    @PostConstruct
    @Scheduled(fixedRate = 10000)
    public void initializeDb() {
        config.getDataSourceList()
                .stream()
                .map(httpClient::getData)
                .forEach(dto -> priceRepository.save(mapper.requestDtoToModel(dto)));
    }
}

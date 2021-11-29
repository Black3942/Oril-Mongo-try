package com.example.orilmongodb.config;

import java.util.List;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
    private static final List<String> dataSourceList = List.of(
            "https://cex.io/api/last_price/BTC/USD",
            "https://cex.io/api/last_price/ETH/USD",
            "https://cex.io/api/last_price/XRP/USD"
    );

    public List<String> getDataSourceList() {
        return dataSourceList;
    }
}

package com.example.orilmongodb.repository;

import com.example.orilmongodb.model.Price;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends MongoRepository<Price, String> {
    @Query(value="{}", fields="{curr1 : 0}")
    List<Price> findByCurr1(String curr1);

    @Query(value="{}", fields="{curr1 : 0}")
    Page<Price> findByCurr1And(String curr1, Pageable pageable);
}

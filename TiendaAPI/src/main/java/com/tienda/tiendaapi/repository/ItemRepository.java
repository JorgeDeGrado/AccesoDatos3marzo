package com.tienda.tiendaapi.repository;

import com.tienda.tiendaapi.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ItemRepository extends MongoRepository<Item, String> {
    List<Item> findByCategory(String category);
    List<Item> findByRateGreaterThan(double rate);
}

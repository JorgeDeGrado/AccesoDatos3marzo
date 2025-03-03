package com.tienda.tiendaapi.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tienda.tiendaapi.model.Item;
import com.tienda.tiendaapi.repository.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.List;

@Configuration
public class DataLoader {

    private final ItemRepository itemRepository;

    @Autowired
    public DataLoader(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Bean
    CommandLineRunner initDatabase() {
        return args -> {
            if (itemRepository.count() == 0) {
                ObjectMapper mapper = new ObjectMapper();
                List<Item> items = mapper.readValue(new File("src/main/resources/store.json"),
                        new TypeReference<>() {});
                itemRepository.saveAll(items);
            }
        };
    }
}

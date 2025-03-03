package com.tienda.tiendaapi.service;

import com.tienda.tiendaapi.model.Item;
import com.tienda.tiendaapi.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public List<Item> obtenerTodos() {
        return itemRepository.findAll();
    }

    public Optional<Item> obtenerPorId(String id) {
        return itemRepository.findById(id);
    }

    public List<Item> obtenerPorCategoria(String categoria) {
        return itemRepository.findByCategory(categoria);
    }

    public Item guardarItem(Item item) {
        return itemRepository.save(item);
    }

    public void eliminarItem(String id) {
        itemRepository.deleteById(id);
    }

    public long contarItems() {
        return itemRepository.count();
    }

    public List<Item> obtenerPorValoracion(double valoracionMinima) {
        return itemRepository.findByRateGreaterThan(valoracionMinima);
    }
}

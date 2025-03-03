package com.tienda.tiendaapi.controller;

import com.tienda.tiendaapi.model.Item;
import com.tienda.tiendaapi.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    // Obtener todos los items
    @GetMapping
    public List<Item> obtenerTodos() {
        return itemService.obtenerTodos();
    }

    // Obtener un item por ID
    @GetMapping("/{id}")
    public Item obtenerPorId(@PathVariable String id) {
        return itemService.obtenerPorId(id).orElse(null);
    }

    // Obtener items por categoría
    @GetMapping("/categoria/{categoria}")
    public List<Item> obtenerPorCategoria(@PathVariable String categoria) {
        return itemService.obtenerPorCategoria(categoria);
    }

    // Crear un nuevo item
    @PostMapping
    public Item crearItem(@RequestBody Item item) {
        return itemService.guardarItem(item);
    }

    // Eliminar un item por ID
    @DeleteMapping("/{id}")
    public void eliminarItem(@PathVariable String id) {
        itemService.eliminarItem(id);
    }

    // Obtener estadísticas de la tienda
    @GetMapping("/estadisticas")
    public Map<String, Object> obtenerEstadisticas(@RequestParam double valoracionMinima) {
        return Map.of(
                "total_items", itemService.contarItems(),
                "items_destacados", itemService.obtenerPorValoracion(valoracionMinima)
        );
    }
}

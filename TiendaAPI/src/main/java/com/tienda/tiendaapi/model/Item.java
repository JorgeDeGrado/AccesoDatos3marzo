package com.tienda.tiendaapi.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "items") // Se guardará en la colección 'items'
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    private String _id;  // Generado automáticamente por MongoDB
    private int id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
    private double rate;
    private int count;
}

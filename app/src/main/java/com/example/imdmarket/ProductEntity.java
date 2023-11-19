package com.example.imdmarket;

public class ProductEntity {
    public int id;
    public int stock;
    public String name;
    public String description;

    ProductEntity(int id, String name, String description, int stock) {
        this.id = id;
        this.stock = stock;
        this.name = name;
        this.description = description;
    }
}

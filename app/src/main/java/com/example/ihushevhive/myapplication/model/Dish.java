package com.example.ihushevhive.myapplication.model;

public class Dish {
    private String name;
    private int price;
    private String category;
    private String supplier;

    public Dish(String name, String category, int price, String supplier) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.supplier = supplier;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

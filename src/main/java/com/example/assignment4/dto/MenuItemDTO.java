package com.example.assignment4.dto;



public class MenuItemDTO {

    private String name;
    private double price;
    private String category;

    public MenuItemDTO() {
    }

    public MenuItemDTO(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {

        return category;
    }
}

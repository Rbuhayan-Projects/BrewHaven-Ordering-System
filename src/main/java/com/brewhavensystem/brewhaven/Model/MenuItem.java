package com.brewhavensystem.brewhaven.Model;

public class MenuItem {

    private final int id;
    private final String name;
    private final String description;
    private final double price;
    private final String category;
    private final String image; // photo file name in static/images, or "" to show the emoji

    public MenuItem(int id, String name, String description,
                    double price, String category, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.image = image;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public String getImage() { return image; }
}
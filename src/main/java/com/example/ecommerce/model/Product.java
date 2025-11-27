package com.example.ecommerce.model;

public class Product {
    private Integer productId;
    private String name;
    private String description;
    private Integer price;
    private String imageUrl;

    public Product() {}

    public Product(Integer productId, String name, String description, Integer price) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Integer getProductId() { return productId; }
    public void setProductId(Integer productId) { this.productId = productId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getPrice() { return price; }
    public void setPrice(Integer price) { this.price = price; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    @Override
    public String toString() {
        return "Product{" + productId + ", " + name + ", " + price + "}";
    }
}

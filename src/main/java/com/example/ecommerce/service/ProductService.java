package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>();

    @PostConstruct
    public void init() {
        // seed sample products
        products.add(new Product(1, "Running Shoes", "Comfortable running shoes", 1200));
        products.add(new Product(2, "Wireless Headphones", "Noise-cancelling headphones", 3500));
        products.add(new Product(3, "Backpack", "Durable travel backpack", 1500));

        // default images folder (ensure placeholder.png exists in static/images)
        for (Product p : products) {
            p.setImageUrl("/images/placeholder.png");
        }
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    public Product getProductById(Integer id) {
        if (id == null) return null;
        return products.stream()
                .filter(p -> id.equals(p.getProductId()))
                .findFirst().orElse(null);
    }

    // overload for Long if controllers supply Long
    public Product getProductById(Long id) {
        if (id == null) return null;
        return getProductById(id.intValue());
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public boolean updateProduct(Integer id, Product newP) {
        Product exists = getProductById(id);
        if (exists == null) return false;
        exists.setName(newP.getName());
        exists.setDescription(newP.getDescription());
        exists.setPrice(newP.getPrice());
        exists.setImageUrl(newP.getImageUrl());
        return true;
    }

    public boolean deleteProduct(Integer id) {
        Product p = getProductById(id);
        return p != null && products.remove(p);
    }

    public int size() {
        return products.size();
    }
}

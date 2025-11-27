package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    private static final String SESSION_CART = "cart";

    @SuppressWarnings("unchecked")
    public List<Product> getCartFromSession(HttpSession session) {
        Object obj = session.getAttribute(SESSION_CART);
        if (obj == null) {
            List<Product> cart = new ArrayList<>();
            session.setAttribute(SESSION_CART, cart);
            return cart;
        }
        return (List<Product>) obj;
    }

    public void addProductToCart(HttpSession session, Product product) {
        if (product == null) return;
        List<Product> cart = getCartFromSession(session);
        cart.add(product);
        session.setAttribute(SESSION_CART, cart);
    }

    public void removeProductFromCart(HttpSession session, int index) {
        List<Product> cart = getCartFromSession(session);
        if (index >= 0 && index < cart.size()) {
            cart.remove(index);
        }
        session.setAttribute(SESSION_CART, cart);
    }

    public int getTotal(List<Product> products) {
        if (products == null) return 0;
        int sum = 0;
        for (Product p : products) {
            if (p != null && p.getPrice() != null) sum += p.getPrice();
        }
        return sum;
    }

    public void clearCart(HttpSession session) {
        session.setAttribute(SESSION_CART, new ArrayList<Product>());
    }
}

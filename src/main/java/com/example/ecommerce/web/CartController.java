package com.example.ecommerce.web;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.CartService;
import com.example.ecommerce.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;
    private final ProductService productService;

    public CartController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    @PostMapping("/add/{id}")
    public String addToCart(@PathVariable("id") Integer id,
                            HttpSession session,
                            RedirectAttributes redirectAttributes) {
        if (id == null) {
            redirectAttributes.addFlashAttribute("error", "Invalid product id");
            return "redirect:/products";
        }
        Product p = productService.getProductById(id);
        if (p == null) {
            redirectAttributes.addFlashAttribute("error", "Product not found");
            return "redirect:/products";
        }
        cartService.addProductToCart(session, p);
        redirectAttributes.addFlashAttribute("success", "Product added to cart");
        return "redirect:/products";
    }

    @GetMapping
    public String viewCart(HttpSession session, Model model) {
        List<Product> cart = cartService.getCartFromSession(session);
        model.addAttribute("cart", cart);
        model.addAttribute("total", cartService.getTotal(cart));
        return "cart";
    }

    @PostMapping("/remove/{index}")
    public String remove(@PathVariable("index") int index,
                         HttpSession session,
                         RedirectAttributes redirectAttributes) {
        cartService.removeProductFromCart(session, index);
        redirectAttributes.addFlashAttribute("success", "Item removed");
        return "redirect:/cart";
    }

    @PostMapping("/checkout")
    public String checkout(HttpSession session, RedirectAttributes redirectAttributes) {
        List<Product> cart = cartService.getCartFromSession(session);
        if (cart == null || cart.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Cart is empty");
            return "redirect:/cart";
        }
        int total = cartService.getTotal(cart);
        cartService.clearCart(session);
        redirectAttributes.addFlashAttribute("success", "Order placed. Total: ₹" + total);
        return "redirect:/confirmation";
    }
}

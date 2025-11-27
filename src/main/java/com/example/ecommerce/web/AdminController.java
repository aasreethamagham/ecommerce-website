package com.example.ecommerce.web;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ProductService productService;
    private final String imagesDir = "src/main/resources/static/images";

    public AdminController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String adminHome(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "admin";
    }

    @GetMapping("/add")
    public String addForm() {
        return "admin-add";
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam String name,
                             @RequestParam String description,
                             @RequestParam Integer price,
                             @RequestParam(value = "image", required = false) MultipartFile image) throws IOException {

        File dir = new File(imagesDir);
        if (!dir.exists()) dir.mkdirs();

        String imagePath = "/images/placeholder.png";
        if (image != null && !image.isEmpty()) {
            String filename = System.currentTimeMillis() + "-" + image.getOriginalFilename();
            File out = new File(dir, filename);
            image.transferTo(out);
            imagePath = "/images/" + filename;
        }

        Integer newId = productService.size() + 1;
        Product p = new Product(newId, name, description, price);
        p.setImageUrl(imagePath);
        productService.addProduct(p);

        return "redirect:/admin";
    }
}

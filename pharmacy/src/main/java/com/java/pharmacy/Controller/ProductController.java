package com.java.pharmacy.Controller;

import com.java.pharmacy.model.Product;
import com.java.pharmacy.service.ProductService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public List<Product> getAllProducts() {
        return productService.getAllProducts()   ;
    }

    public Product getProductById(@PathVariable Long id) {
        return productService.findById(id).orElseThrow();
    }
}

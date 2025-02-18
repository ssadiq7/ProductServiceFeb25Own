package com.scaler.productservicefeb25.controllers;

import com.scaler.productservicefeb25.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    // http://localhost:8080/products/1 => GET
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") long id) {
        return null;
    }

    // http://localhost:8080/products => GET
    @GetMapping
    public List<Product> getAllProducts() {
        return null;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return null;
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") long id, @RequestBody Product product) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") long id) {
    }

}

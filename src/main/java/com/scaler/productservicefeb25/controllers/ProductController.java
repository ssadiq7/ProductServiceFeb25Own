package com.scaler.productservicefeb25.controllers;

import com.scaler.productservicefeb25.models.Product;
import com.scaler.productservicefeb25.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // http://localhost:8080/products/1 => GET
    @GetMapping("/{id}")
    //public Product getProductById(@PathVariable("id") long id) {
    public ResponseEntity<Product> getProduct(@PathVariable long id) {
        //return productService.getProductById(id);
        Product product = productService.getProductById(id);
        /*if (product == null) { // This block is the proper way of implementing the response entity return
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);*/

        // This block is the shorthand way of implementing the response entity return
        // Taught in the class
        return new ResponseEntity<>(
                product,
                //HttpStatus.OK
                //HttpStatus.SERVICE_UNAVAILABLE
                HttpStatus.NOT_FOUND
        );

        //throw new RuntimeException("This is a runtime exception");
    }

    // http://localhost:8080/products => GET
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
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

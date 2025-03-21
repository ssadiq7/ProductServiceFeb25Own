package com.scaler.productservicefeb25.controllers;

import com.scaler.productservicefeb25.exceptions.ProductNotFoundException;
import com.scaler.productservicefeb25.models.Product;
import com.scaler.productservicefeb25.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(@Qualifier("selfProductService") ProductService productService) {
        this.productService = productService;
    }

    // http://localhost:8080/products/1 => GET
    @GetMapping("/{id}")
    //public Product getProductById(@PathVariable("id") long id) {
    //public ResponseEntity<Product> getProduct(@PathVariable long id) {
    public Product getProductById(@PathVariable("id") long id) throws ProductNotFoundException {
        //return productService.getProductById(id);
        //Product product = productService.getProductById(id);
        /*if (product == null) { // This block is the proper way of implementing the response entity return
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);*/

        // Exception handling
        /*try { // Auto generated
            Product product = productService.getProductById(id);
            return ResponseEntity.ok(product);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }*/
        // What's taught in the class
//        ResponseEntity<Product> responseEntity = null;
//
//        try {
//            Product product = productService.getProductById(id);
//
//            responseEntity = new ResponseEntity<>(
//                    product,
//                    HttpStatus.OK
//            );
//        } catch (ProductNotFoundException e) {
//            responseEntity = new ResponseEntity<>(
//                    null,
//                    HttpStatus.NOT_FOUND
//            );
//        }

        return productService.getProductById(id);

        // This block is the shorthand way of implementing the response entity return
        // Taught in the class
        /*return new ResponseEntity<>(
                product,
                //HttpStatus.OK
                //HttpStatus.SERVICE_UNAVAILABLE
                HttpStatus.NOT_FOUND
        );*/

        //throw new RuntimeException("This is a runtime exception");
    }

    // http://localhost:8080/products => GET
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PatchMapping
    public Product updateProduct(@PathVariable("id") long id,
                                 @RequestBody Product product) {
        //return productService.updateProduct(product);
        return null;
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") long id,
                                  @RequestBody Product product) throws ProductNotFoundException {
        return productService.replaceProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public Product deleteProduct(@PathVariable("id") long id) throws ProductNotFoundException {
        return productService.deleteProduct(id);
    }


    /*@ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException e) {
        return new ResponseEntity<>(
                e.getMessage() + " from controller",
                HttpStatus.SERVICE_UNAVAILABLE
        );
    }*/

}

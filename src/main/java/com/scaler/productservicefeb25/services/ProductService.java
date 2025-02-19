package com.scaler.productservicefeb25.services;

import com.scaler.productservicefeb25.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(long id);
    List<Product> getAllProducts();
    Product createProduct(Product product);
    Product replaceProduct(long id, Product product);
    void deleteProduct(long id);
}

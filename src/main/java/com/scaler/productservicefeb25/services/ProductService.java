package com.scaler.productservicefeb25.services;

import com.scaler.productservicefeb25.exceptions.ProductNotFoundException;
import com.scaler.productservicefeb25.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(long id) throws ProductNotFoundException; // GET mapping
    List<Product> getAllProducts(); // GET mapping
    Product createProduct(Product product); // POST mapping
    Product updateProduct(long id, Product product); // PATCH mapping
    Product replaceProduct(long id, Product product) throws ProductNotFoundException; // PUT mapping
    Product deleteProduct(long id) throws ProductNotFoundException; // DELETE mapping
}

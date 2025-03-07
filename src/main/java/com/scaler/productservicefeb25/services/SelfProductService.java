package com.scaler.productservicefeb25.services;

import com.scaler.productservicefeb25.exceptions.ProductNotFoundException;
import com.scaler.productservicefeb25.models.Product;

import java.util.List;

public class SelfProductService implements ProductService {

    @Override
    public Product getProductById(long id) throws ProductNotFoundException {
        // Make a DB call to get the product with given Id.
        // Select * from products where id = id;
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(long id) {

    }
}

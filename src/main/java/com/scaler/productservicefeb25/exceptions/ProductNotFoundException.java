package com.scaler.productservicefeb25.exceptions;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String message) {
        super(message); // Calls the constructor of the parent class
    }
}

package com.scaler.productservicefeb25.services;

import com.scaler.productservicefeb25.dtos.FakeStoreProductDto;
import com.scaler.productservicefeb25.exceptions.ProductNotFoundException;
import com.scaler.productservicefeb25.models.Category;
import com.scaler.productservicefeb25.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {
    // This service will be used to interact with the FakeStore API

    private final RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(long productId) throws ProductNotFoundException {
        // This method will fetch the product from the FakeStore API
        // using the id provided
        // and return the product
        // If the product is not found, return null
        // https://fakestoreapi.com/products/1

        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + productId,
                FakeStoreProductDto.class);

        if (fakeStoreProductDto == null) {
            //return null;
            throw new ProductNotFoundException("Product with id: " + productId + " doesn't exist!");
        }

        // Convert FakeStoreProductDto to Product
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
        //throw new RuntimeException("This is a runtime exception");
    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setImageUrl(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());

        Category category = new Category();
        category.setName(fakeStoreProductDto.getCategory());
        product.setCategory(category);

        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);

        if (fakeStoreProductDtos == null) {
            return null;
        }

        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }

        return products;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(long id, Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(long id, Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(long id) {
        return null;
    }
}

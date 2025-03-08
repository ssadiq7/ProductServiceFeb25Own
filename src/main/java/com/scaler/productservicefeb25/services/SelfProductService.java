package com.scaler.productservicefeb25.services;

import com.scaler.productservicefeb25.exceptions.ProductNotFoundException;
import com.scaler.productservicefeb25.models.Product;
import com.scaler.productservicefeb25.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
/* @Primary // This is the annotation that tells Spring to use this implementation of ProductService
* instead of the other one
* Another way to do this is to use the @Qualifier annotation in the constructor of the ProductController
* Mentioning @Qualifier annotation in the ProductController is better because it is more specific and can be used to specify which implementation
* of the ProductService to use in the constructor of the ProductController
* This way other controllers can use other implementation of ProductService as per their requirement
* If we use @Primary annotation, then all the controllers will use this implementation of ProductService
 */
public class SelfProductService implements ProductService {

    private ProductRepository productRepository;

    public SelfProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /*
    * Because we are going to use ORM, we don't need to write queries to get the data from the database
    * We can use the ORM to get the data from the database
    * ORM means Object Relational Mapping
    * ORM methods are provided by the Spring Data JPA
    * Hibernate (an ORM tool) will write the queries on our behalf based on the function/method names
    *
    * Example: findById(long id) => Select * from products where id = id;
    * findByEmail(String email) => Select * from products where email = email;
    * findByTitleAndQuantityGreaterThan(String title, int quantity) => Select * from products where title = title and quantity > quantity;
    * https://docs.spring.io/spring-data/jpa/reference/repositories/query-keywords-reference.html
    *
    * These are called declared queries - no need to write the queries on our own
    * Just need to declare the method in the interface and Spring Data JPA will write the query for us
    *
    * For database, we will create a new package called repositories
    * In the repositories package, we will create an interface called ProductRepository
    * This interface will extend the JpaRepository interface
    * JpaRepository interface is a generic interface that takes two parameters
    * First parameter is the entity class and the second parameter is the type of the primary key of the entity class
    * In our case, the entity class is Product and the primary key is long
    * So, the ProductRepository interface will extend the JpaRepository interface with Product and long as the parameters
     */

    @Override
    public Product getProductById(long productId) throws ProductNotFoundException {
        // Make a DB call to get the product with given Id.
        // Select * from products where id = id;

        // If the product is not found, throw a ProductNotFoundException
        // If the product is found, return the product
        // This is an autoggenerated code by the IDE
        /* return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " not found"));
         */

        // The above code is equivalent to the following code (coded by the instructor)
        Optional<Product> optionalProduct = productRepository.findById(productId);

        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException("Product with id " + productId + " not found");
        }

        return optionalProduct.get();
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

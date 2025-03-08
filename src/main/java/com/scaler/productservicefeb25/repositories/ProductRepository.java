package com.scaler.productservicefeb25.repositories;

import com.scaler.productservicefeb25.models.Category;
import com.scaler.productservicefeb25.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    /*
    * The methods in this interface are coming from the JpaRepository interface
    * And Hibernate implements these methods for us
    * Single responsibility principle - this interface is only responsible for the database operations
     */

    @Override
    Optional<Product> findById(Long productId);
    // select * from products where id = productId;
    // Optional is a wrapper class that may or may not contain a non-null value
    // If the value is present, isPresent() will return true and get() will return the value
    // Wrapping the return type in Optional is a good practice because it forces the developer to handle the null case
    // If the value is not present, isPresent() will return false and get() will throw a NoSuchElementException

    List<Product> findAll();
    // select * from products;
    
    Product save(Product product);
    // insert into products values (product);
    
    void deleteById(Long productId);
    // delete from products where id = productId;
    
    /*

    void updateProductUsingId(Long productId, Product product);
    // update products set product = product where id = productId;
    
    List<Product> findByCategory_Id(long categoryId);
    // select * from products where category_id = categoryId;

    List<Product> findByCategory(Category category);
    // select *
    // from products p
    // join categories c
    // on p.category_id = c.category_id
    // and c.category = category;

     */

    
}

package com.scaler.productservicefeb25.repositories;

import com.scaler.productservicefeb25.models.Category;
import com.scaler.productservicefeb25.models.Product;
import com.scaler.productservicefeb25.projections.ProductWithTitleAndPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Override
    List<Product> findAll();
    // select * from products;

    @Override // @Override is optional here but it is a good practice to use it
    Product save(Product product);
    // this is an upsert operation, can be used for both insert and update
    // insert into products values (product);
    // update products set product = product where id = productId;

    @Override // @Override is optional because this is an interface method
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




    // select title, price from products where id = productId;
    // HQL - Hibernate Query Language
    // JPQL - Java Persistence Query Language
    // We can write HQL queries based on the entity classes / models and their fields / attributes
    //@Query("select p.title, p.price from Product p where p.id = :productId") // HQL & JPQL
    //List<ProductWithTitleAndPrice> findTitleAndPriceById(@Param("productId") Long productId);


    // SQL - Structured Query Language | Native Query
    //@Query(value = "select p.title, p.price from products p where p.id = :productId", nativeQuery = true)
    //List<ProductWithTitleAndPrice> findTitleAndPriceById(@Param("productId") Long productId);

    // SQL coded by the instructor
    @Query(value = "select p.title, p.price from products p where p.title = :title and p.price = :price", nativeQuery = true)
    List<ProductWithTitleAndPrice> getProductTitleAndPriceSQL(@Param("title") String title, @Param("price") double price);

    
}

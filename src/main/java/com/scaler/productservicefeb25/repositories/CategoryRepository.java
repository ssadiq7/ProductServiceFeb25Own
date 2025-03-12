package com.scaler.productservicefeb25.repositories;

import com.scaler.productservicefeb25.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(String name);
    // select * from categories where name = name;

    @Override // this is an annotation that tells the compiler that the following method is an overridden method
    Category save(Category category);
    // this is an upsert operation, can be used for both insert and update

    void deleteById(Long id);

}

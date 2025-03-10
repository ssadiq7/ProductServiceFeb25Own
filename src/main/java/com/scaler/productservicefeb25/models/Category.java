package com.scaler.productservicefeb25.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "categories")
public class Category extends BaseModel {
    private String name;

    @OneToMany(mappedBy = "category") // mappedBy is used to specify the field in the Product class that owns the relationship
    // If we do not mention mappedBy then Spring will create an additional table to maintain the relationship
    // mappedBy can be used only on the non-owning side of the relationship, that is, only on the Many side of the OneToMany relationship
    private List<Product> products; // This is not a column in the database, it is a field in the entity class
    // This List will fetch all the products that belong to this category
}

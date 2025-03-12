package com.scaler.productservicefeb25.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "products")
public class Product extends BaseModel {
// The Product class is an entity class that represents the products table in the database. It extends the BaseModel class, which is a superclass for other entity classes. The Product class has the following fields:
    private String title;
    private String description;
    private String imageUrl;
    private double price;

    @ManyToOne//(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}) // This annotation is used to specify the many-to-one relationship between the Product and Category entities.
    // The cascade attribute is used to specify the cascade operations that should be applied to the associated entities when the owning entity is persisted, merged, removed, or refreshed.
    // Because of the cascade attribute we were able to discard the additional logic we coded in SelfProductService.java
    // to save the category before saving the product
    // While using CascadeType.PERSIST make sure that unique constraint is enforced on name attribute of Category model
    // If unique constraint is not enforced then we can keep adding duplicate entries for category name
    // When unique constraint is enforced then we will get an exception if we try to add duplicate entries
    // This does not serve our purpose of reusing the category name if it already exists
    // So we will switch back to our custom code to save the category if it does not exist and to use the existing category if it already exists
    @JoinColumn(name = "category_id")
    private Category category;
}

/*         BaseModel---
 *              |     |
 *              |     |
 *          Product   |
 *              |     |
 *              |     |
 *              Category
 *
 *
 *
 * xY => x_y
 *
 *          1           1
*       Product ==== Category ==> M:1
*           M           1
 */
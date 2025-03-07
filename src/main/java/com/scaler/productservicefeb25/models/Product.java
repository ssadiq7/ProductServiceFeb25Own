package com.scaler.productservicefeb25.models;

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

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}

/*         BaseModel
 *              |
 *              |
 *          Product
 *              |
 *              |
 *          Category
 *
 *          1           1
*       Product ==== Category ==> M:1
*           M           1
 */
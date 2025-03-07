package com.scaler.productservicefeb25.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass // This annotation is used to specify that the class is an entity class that is a superclass for other entity classes.
public class BaseModel {
    @Id // This annotation is used to specify the primary key of an entity.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This annotation is used to specify the generation strategy for the primary key.
    private long id;
    private Date createdAt;
    private Date lastModifiedAt;
    private boolean isDeleted;
}

/*
The BaseModel class is an entity class that is a superclass for other entity classes. It has the following fields:
    id: The primary key of the entity.
    createdAt: The date and time when the entity was created.
    lastModifiedAt: The date and time when the entity was last modified.
    isDeleted: A flag that indicates whether the entity is deleted or not.
 */

/*
The @MappedSuperclass annotation is used to specify that the class is an entity class that is a superclass for other entity classes. This annotation is used to define the inheritance strategy for the entity classes. When an entity class extends a class with the @MappedSuperclass annotation, it inherits the fields and properties of the superclass.
No table for the superclass is created in the database. Instead, the fields and properties of the superclass are added to the table of the subclass. This allows the subclass to reuse the fields and properties of the superclass without creating a separate table for the superclass.
In this case, the BaseModel class is a superclass for other entity classes such as Product and Category. The fields of the BaseModel class are inherited by the Product and Category classes, and the Product and Category classes have their own tables in the database that include the fields of the BaseModel class.

Other inheritance strategies in JPA include:
    - Single Table Inheritance: All classes in the hierarchy are mapped to a single table in the database.
    - Joined Table Inheritance: Each class in the hierarchy is mapped to a separate table in the database, and a join operation is used to retrieve data from multiple tables.
    - Table Per Class Inheritance: Each class in the hierarchy is mapped to a separate table in the database, and no join operation is required to retrieve data from multiple tables.
 */
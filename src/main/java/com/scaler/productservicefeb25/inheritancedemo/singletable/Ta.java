package com.scaler.productservicefeb25.inheritancedemo.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "3")
public class Ta extends User {
    private int numberOfHelpRequests;
    private double avgRating;
}

package com.scaler.productservicefeb25.inheritancedemo.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "msc_tas")
public class Ta extends User {
    private int numberOfHelpRequests;
    private double avgRating;
}

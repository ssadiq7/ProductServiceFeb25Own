package com.scaler.productservicefeb25.inheritancedemo.singletable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Instructor extends User {
    private String specialization;
    private double avgRating;
}

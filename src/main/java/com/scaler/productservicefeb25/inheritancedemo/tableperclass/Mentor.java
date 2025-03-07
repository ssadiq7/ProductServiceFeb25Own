package com.scaler.productservicefeb25.inheritancedemo.tableperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mentor extends User {
    private String companyName;
    private double avgRating;
}

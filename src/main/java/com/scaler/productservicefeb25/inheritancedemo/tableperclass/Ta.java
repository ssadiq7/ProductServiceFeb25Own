package com.scaler.productservicefeb25.inheritancedemo.tableperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ta extends User {
    private int numberOfHelpRequests;
    private double avgRating;
}

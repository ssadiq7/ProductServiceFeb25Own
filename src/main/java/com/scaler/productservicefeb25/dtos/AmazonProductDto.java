package com.scaler.productservicefeb25.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AmazonProductDto {
    private long id;
    private String name;
    private double amount;
    private String description;
}

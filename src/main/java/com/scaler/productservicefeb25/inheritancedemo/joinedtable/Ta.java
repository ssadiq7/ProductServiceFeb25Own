package com.scaler.productservicefeb25.inheritancedemo.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_tas")
@PrimaryKeyJoinColumn(name = "user_id")
public class Ta extends User {
    private int numberOfHelpRequests;
    private double avgRating;
}

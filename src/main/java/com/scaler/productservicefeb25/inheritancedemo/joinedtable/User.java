package com.scaler.productservicefeb25.inheritancedemo.joinedtable;

import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    private long id;
    private String name;
    private String email;
    private String password;
}

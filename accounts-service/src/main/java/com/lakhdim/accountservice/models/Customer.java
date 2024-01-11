package com.lakhdim.accountservice.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Customer {
    private Long id;
    private String lastName;
    private String firstName;
    private String email;
}


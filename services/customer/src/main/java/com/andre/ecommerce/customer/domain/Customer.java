package com.andre.ecommerce.customer.domain;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Customer {
    private final CustomerId id;
    private final CustomerBirthdate birthdate;
    private final CustomerEmail email;

    public Customer(
            String id,
            LocalDate birthdate,
            String email
    ) {
        this.id = new CustomerId(id);
        this.birthdate = new CustomerBirthdate(birthdate);
        this.email = new CustomerEmail(email);
    }

}

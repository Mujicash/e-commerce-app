package com.andre.ecommerce.customer.domain;

import java.time.LocalDate;

public class Customer {
    private CustomerId id;
    private CustomerBirthdate birthdate;
    private CustomerEmail email;

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

package com.andre.ecommerce.customer.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDate;

@EqualsAndHashCode
public class Customer {
    private final CustomerId id;
    private final CustomerBirthdate birthdate;
    private final CustomerEmail email;
    @Getter
    private final CustomerAddress address;

    public Customer(
            String id,
            LocalDate birthdate,
            String email,
            CustomerAddress address
    ) {
        this.id = new CustomerId(id);
        this.birthdate = new CustomerBirthdate(birthdate);
        this.email = new CustomerEmail(email);
        this.address = address;
    }

    public String getId() {
        return id.getValue();
    }

    public LocalDate getBirthdate() {
        return birthdate.getValue();
    }

    public String getEmail() {
        return email.getValue();
    }

}

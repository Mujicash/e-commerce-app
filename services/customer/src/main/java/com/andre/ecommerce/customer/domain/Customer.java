package com.andre.ecommerce.customer.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@EqualsAndHashCode
public class Customer {
    private final CustomerId id;
    private final CustomerBirthdate birthdate;
    private final CustomerEmail email;
    private final List<CustomerAddress> address;
    @Getter @Setter
    private String firstName;
    @Getter @Setter
    private String lastName;

    public Customer(
            String id,
            LocalDate birthdate,
            String email,
            String firstName,
            String lastName
    ) {
        this(id, birthdate, email, firstName, lastName, new ArrayList<>());
    }

    public Customer(
            String id,
            LocalDate birthdate,
            String email,
            String firstName,
            String lastName,
            List<CustomerAddress> address
    ) {
        this.id = new CustomerId(id);
        this.birthdate = new CustomerBirthdate(birthdate);
        this.email = new CustomerEmail(email);
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = new ArrayList<>(address);
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

    public void addAddress(CustomerAddress address) {
        if (address != null) {
            this.address.add(address);
        }
    }

    public List<CustomerAddress> getAddresses() {
        return Collections.unmodifiableList(address);
    }

}

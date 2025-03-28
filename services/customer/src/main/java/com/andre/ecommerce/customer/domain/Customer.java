package com.andre.ecommerce.customer.domain;

import com.andre.ecommerce.shared.domain.UuidValueObject;
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

    private Customer(
            String id,
            LocalDate birthdate,
            String email,
            String firstName,
            String lastName,
            List<CustomerAddress> addresses
    ) {
        this.id = new CustomerId(id);
        this.birthdate = new CustomerBirthdate(birthdate);
        this.email = new CustomerEmail(email);
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = new ArrayList<>(addresses);
    }

    public static Customer create(
            LocalDate birthdate,
            String email,
            String firstName,
            String lastName,
            CustomerAddress address
    ) {
        String id = UuidValueObject.create().getValue();
        return new Customer(
                id,
                birthdate,
                email,
                firstName,
                lastName,
                address != null ? List.of(address) : List.of()
        );
    }

    public static Customer restore(
            String id,
            LocalDate birthdate,
            String email,
            String firstName,
            String lastName,
            List<CustomerAddress> addresses
    ) {
        return new Customer(
                id,
                birthdate,
                email,
                firstName,
                lastName,
                addresses
        );
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

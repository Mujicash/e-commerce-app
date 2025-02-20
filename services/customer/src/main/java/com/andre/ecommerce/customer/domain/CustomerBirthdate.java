package com.andre.ecommerce.customer.domain;

import com.andre.ecommerce.shared.domain.DateValueObject;

import java.time.LocalDate;

public class CustomerBirthdate extends DateValueObject {

    public CustomerBirthdate(String value) {
        super(value);
        ensureIsValidBirthdate(this.getValue());
    }

    public CustomerBirthdate(LocalDate value) {
        super(value);
        ensureIsValidBirthdate(value);
    }

    private void ensureIsValidBirthdate(LocalDate birthdate) {
        LocalDate today = LocalDate.now();
        int age = today.getYear() - birthdate.getYear();

        if (today.getMonthValue() < birthdate.getMonthValue() ||
                (today.getMonthValue() == birthdate.getMonthValue() && today.getDayOfMonth() < birthdate.getDayOfMonth())) {
            age--; // Ajustar la edad si el cumpleaños aún no ha ocurrido este año
        }

        if (age < 18 || age > 90) {
            throw new IllegalArgumentException(String.format("Invalid birthdate: %d", age));
        }
    }
}

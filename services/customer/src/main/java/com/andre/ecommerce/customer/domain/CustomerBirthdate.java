package com.andre.ecommerce.customer.domain;

import com.andre.ecommerce.shared.domain.DateValueObject;

import java.time.LocalDate;
import java.util.Date;

public class CustomerBirthdate extends DateValueObject {
    public CustomerBirthdate(Date value) {
        super(value);
        this.ensureIsValidBirthdate(value);
    }

    private void ensureIsValidBirthdate(Date value) {
        LocalDate currentDate = LocalDate.now();
        int ageInYears = currentDate.getYear() - value.getYear();

        if (currentDate.getMonthValue() < value.getMonth() ||
                (currentDate.getMonthValue() == value.getMonthValue() && currentDate.getDayOfMonth() < value.getDayOfMonth())) {
            ageInYears--;
        }
    }
}

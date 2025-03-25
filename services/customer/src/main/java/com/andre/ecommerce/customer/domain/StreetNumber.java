package com.andre.ecommerce.customer.domain;

import com.andre.ecommerce.shared.domain.InvalidValueException;
import com.andre.ecommerce.shared.domain.StringValueObject;
import com.andre.ecommerce.shared.domain.ValueObject;

public class StreetNumber extends ValueObject<Integer> {
    public StreetNumber(int value) {
        super(value);
        ensureIsPositive(value);
    }

    private void ensureIsPositive(int value) {
        if (value < 0) {
            throw new InvalidValueException(
                    String.format("Invalid street number: %d. Must be a positive number.", value)
            );
        }
    }
}

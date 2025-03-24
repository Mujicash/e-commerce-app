package com.andre.ecommerce.customer.domain;

import com.andre.ecommerce.shared.domain.InvalidValueException;
import com.andre.ecommerce.shared.domain.StringValueObject;

import java.util.regex.Pattern;

public class PostalCode extends StringValueObject {
    private static final Pattern EXACTLY_FIVE_DIGITS = Pattern.compile("^\\d{5}$");

    public PostalCode(String value) {
        super(value);
        ensureIsValidPostalCode(value);
    }

    private void ensureIsValidPostalCode(String value) {
        if (!EXACTLY_FIVE_DIGITS.matcher(value).matches()) {
            throw new InvalidValueException(
                    String.format(
                            "Invalid postal code: %s. Must contain exactly 5 numeric digits.",
                            value
                    )
            );
        }
    }
}

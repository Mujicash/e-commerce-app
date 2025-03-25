package com.andre.ecommerce.customer.domain;

import com.andre.ecommerce.shared.domain.InvalidValueException;
import com.andre.ecommerce.shared.domain.StringValueObject;

import java.util.regex.Pattern;

public class CustomerEmail extends StringValueObject {
    private static final Pattern VALID_EMAIL_REGEX = Pattern.compile("^[A-Za-z0-9](?:[A-Za-z0-9]*\\.?[A-Za-z0-9]+){5,29}@(?:gmail\\.com|hotmail\\.com)$");

    public CustomerEmail(String value) {
        super(value);
        this.ensureIsValidEmail(value);
    }

    private void ensureIsValidEmail(String value) {
        if (!VALID_EMAIL_REGEX.matcher(value).matches()) {
            throw new InvalidValueException(String.format("Invalid email address: %s", value));
        }
    }
}

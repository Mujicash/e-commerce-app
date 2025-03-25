package com.andre.ecommerce.customer.domain;

import com.andre.ecommerce.shared.domain.InvalidValueException;
import com.andre.ecommerce.shared.domain.StringValueObject;

import java.util.regex.Pattern;

public class FloorApartment extends StringValueObject {
    // Permite números seguidos opcionalmente de letras (ej.: "105", "1013", "405A")
    private static final Pattern FLOOR_PATTERN = Pattern.compile("^[0-9]+[A-Za-z]*$");

    public FloorApartment(String value) {
        super(value);
        ensureValidFloor(value);
    }

    private void ensureValidFloor(String value) {
        if (!FLOOR_PATTERN.matcher(value).matches()) {
            throw new InvalidValueException(String.format("Invalid floor/apartment: %s", value));
        }
    }
}

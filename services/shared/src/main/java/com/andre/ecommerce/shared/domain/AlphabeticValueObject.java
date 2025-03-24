package com.andre.ecommerce.shared.domain;

import java.util.regex.Pattern;

public abstract class AlphabeticValueObject extends StringValueObject {
    private static final Pattern ALPHA_SPACE_PATTERN = Pattern.compile("^[A-Za-z ]+$");

    public AlphabeticValueObject(String value) {
        super(value);
        ensureIsAlphabetic(value);
    }

    // Cada clase concreta debe indicar el nombre del campo.
    protected abstract String getFieldName();

    private void ensureIsAlphabetic(String value) {
        if (!ALPHA_SPACE_PATTERN.matcher(value).matches()) {
            throw new InvalidValueException(
                    String.format(
                            "Invalid %s: %s. Must contain only alphabetic characters and spaces.",
                            getFieldName(),
                            value
                    )
            );
        }
    }
}

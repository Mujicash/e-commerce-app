package com.andre.ecommerce.shared.domain;

import java.util.UUID;

public class UuidValueObject extends ValueObject<String> {
    public UuidValueObject(String value) {
        super(value);
        ensureIsValidUuid(value);
    }

    public static UuidValueObject create() {
        return new UuidValueObject(UUID.randomUUID().toString());
    }

    private void ensureIsValidUuid(String value) {
        try {
            UUID.fromString(value);
        } catch (IllegalArgumentException e) {
            throw new InvalidValueException(String.format("<%s> is not a valid <%s>", value, this.getClass().getSimpleName()));
        }
    }
}

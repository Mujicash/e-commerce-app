package com.andre.ecommerce.shared.domain;

import java.io.Serializable;
import java.util.Objects;

public abstract class ValueObject <T extends Serializable> {
    protected final T value;

    public ValueObject(T value) {
        this.ensureValueIsDefined(value);
        this.value = value;
    }

    public boolean equals(ValueObject<T> other) {
        return other != null &&
                this.getClass().equals(other.getClass()) &&
                Objects.equals(this.value, other.value);
    }

    @Override
    public String toString() {
        return this.value.toString();
    }

    public T getValue() {
        return this.value;
    }

    private void ensureValueIsDefined(T value) {
        if (value == null) {
            throw new InvalidValueException("Value must be defined.");
        }
    }
}

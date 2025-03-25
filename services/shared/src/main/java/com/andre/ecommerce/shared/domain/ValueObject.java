package com.andre.ecommerce.shared.domain;

import java.io.Serializable;
import java.util.Objects;

public abstract class ValueObject <T extends Serializable> {
    protected final T value;

    public ValueObject(T value) {
        this.ensureValueIsDefined(value);
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValueObject<?> that = (ValueObject<?>) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
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

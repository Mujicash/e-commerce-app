package com.andre.ecommerce.customer.domain;

import com.andre.ecommerce.shared.domain.AlphabeticValueObject;

public class StreetName extends AlphabeticValueObject {

    public StreetName(String value) {
        super(value);
    }

    @Override
    protected String getFieldName() {
        return "StreetName";
    }
}

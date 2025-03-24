package com.andre.ecommerce.customer.domain;

import com.andre.ecommerce.shared.domain.AlphabeticValueObject;

public class StreetType extends AlphabeticValueObject {

    public StreetType(String value) {
        super(value);
    }

    @Override
    protected String getFieldName() {
        return "StreetType";
    }
}

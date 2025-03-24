package com.andre.ecommerce.customer.domain;

import com.andre.ecommerce.shared.domain.AlphabeticValueObject;

public class Province extends AlphabeticValueObject {

    public Province(String value) {
        super(value);
    }

    @Override
    protected String getFieldName() {
        return "Province";
    }
}

package com.andre.ecommerce.customer.domain;

import com.andre.ecommerce.shared.domain.AlphabeticValueObject;

public class Department extends AlphabeticValueObject {

    public Department(String value) {
        super(value);
    }

    @Override
    protected String getFieldName() {
        return "Department";
    }
}

package com.andre.ecommerce.customer.domain;

import com.andre.ecommerce.shared.domain.AlphabeticValueObject;

public class District extends AlphabeticValueObject {

    public District(String value) {
        super(value);
    }

    @Override
    protected String getFieldName() {
        return "District";
    }
}

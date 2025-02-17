package com.andre.ecommerce.shared.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValueObject extends ValueObject<Date> {
    private static final SimpleDateFormat ISO_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    public DateValueObject(Date value) {
        super(value);
    }

    @Override
    public String toString() {
        return ISO_FORMAT.format(value);
    }
}

package com.andre.ecommerce.shared.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateValueObject extends ValueObject<LocalDate> {
    private static final SimpleDateFormat INPUT_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    private static final SimpleDateFormat ISO_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    public DateValueObject(LocalDate value) {
        super(value);
    }

    public DateValueObject(String value) {
        super(parseDate(value));
    }

    private static LocalDate parseDate(String value) {
        try {
            Date parsedDate = INPUT_FORMAT.parse(value);
            return parsedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        } catch (ParseException e) {
            throw new InvalidValueException(String.format("Invalid date format <%s>. Expected format: dd/MM/yyyy", value));
        }
    }

    @Override
    public String toString() {
        return ISO_FORMAT.format(toDate());
    }

    /**
     * Convierte LocalDate a Date para compatibilidad con APIs antiguas.
     */
    public Date toDate() {
        return Date.from(value.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}

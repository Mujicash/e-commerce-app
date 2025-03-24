package com.andre.ecommerce.customer.domain;

import java.util.Optional;

public class Address {
    private Department department;
    private Province province;
    private District district;
    private PostalCode postalCode;
    private StreetType streetType;
    private StreetName streetName;
    private Optional<StreetNumber> streetNumber;
    private Optional<String> floorApartment;
    private Optional<String> reference;
}

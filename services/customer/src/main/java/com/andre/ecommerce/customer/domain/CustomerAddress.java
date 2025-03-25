package com.andre.ecommerce.customer.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Objects;
import java.util.Optional;

@Getter
@EqualsAndHashCode
public class CustomerAddress {
    private final Department department;
    private final Province province;
    private final District district;
    private final PostalCode postalCode;
    private final StreetType streetType;
    private final StreetName streetName;
    private final Optional<StreetNumber> streetNumber;
    private final Optional<FloorApartment> floorApartment;
    private final Optional<String> reference;

    public CustomerAddress(
            String department,
            String province,
            String district,
            String postalCode,
            String streetType,
            String streetName,
            Integer streetNumber,
            String floorApartment,
            String reference
    ) {
        this.department = new Department(department);
        this.province = new Province(province);
        this.district = new District(district);
        this.postalCode = new PostalCode(postalCode);
        this.streetType = new StreetType(streetType);
        this.streetName = new StreetName(streetName);
        this.streetNumber = streetNumber != null ? Optional.of(new StreetNumber(streetNumber)) : Optional.empty();
        this.floorApartment = (floorApartment != null && !floorApartment.trim().isEmpty()) ? Optional.of(new FloorApartment(floorApartment)) : Optional.empty();
        this.reference = reference != null ? Optional.of(reference) : Optional.empty();
    }
}

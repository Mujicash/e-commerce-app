package com.andre.ecommerce.customer.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Optional;

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

    public String getDepartment() {
        return department.getValue();
    }

    public String getProvince() {
        return province.getValue();
    }

    public String getDistrict() {
        return district.getValue();
    }

    public String getPostalCode() {
        return postalCode.getValue();
    }

    public String getStreetType() {
        return streetType.getValue();
    }

    public String getStreetName() {
        return streetName.getValue();
    }

    public Integer getStreetNumber() {
        return streetNumber.map(StreetNumber::getValue).orElse(null);
    }

    public String getFloorApartment() {
        return floorApartment.map(FloorApartment::getValue).orElse(null);
    }

    public String getReference() {
        return reference.orElse(null);
    }

}

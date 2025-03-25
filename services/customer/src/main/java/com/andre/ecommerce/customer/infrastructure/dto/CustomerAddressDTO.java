package com.andre.ecommerce.customer.infrastructure.dto;

public record CustomerAddressDTO(
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
}

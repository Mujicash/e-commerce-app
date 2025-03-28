package com.andre.ecommerce.customer.infrastructure.dto;

import java.time.LocalDate;

public record CustomerCreateDTO(
        LocalDate birthdate,
        String email,
        String firstName,
        String lastName,
        CustomerAddressDTO address
) {
}

package com.andre.ecommerce.customer.infrastructure.dto;

import java.time.LocalDate;

public record CustomerResponseDTO(
        String id,
        String firstname,
        String lastname,
        LocalDate birthdate,
        String email
) {
}

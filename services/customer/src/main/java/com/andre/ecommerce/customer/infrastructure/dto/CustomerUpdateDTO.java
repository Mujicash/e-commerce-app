package com.andre.ecommerce.customer.infrastructure.dto;

public record CustomerUpdateDTO(
        String id,
        String firstname,
        String lastname
) {
}

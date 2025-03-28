package com.andre.ecommerce.customer.infrastructure.mapper;

import com.andre.ecommerce.customer.domain.Customer;
import com.andre.ecommerce.customer.domain.CustomerAddress;
import com.andre.ecommerce.customer.infrastructure.dto.CustomerCreateDTO;

import java.util.List;

public class CustomerMapper {

    // DTO -> domain model
    public static Customer toDomain(CustomerCreateDTO dto) {
        if (dto == null) {
            return null;
        }

        CustomerAddress address = null;

        if (dto.address() != null) {
            address = CustomerAddressMapper.toDomain(dto.address());
        }

        return Customer.create(
                dto.birthdate(),
                dto.email(),
                dto.firstName(),
                dto.lastName(),
                address
        );
    }
}

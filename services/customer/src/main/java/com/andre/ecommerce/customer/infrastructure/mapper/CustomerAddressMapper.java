package com.andre.ecommerce.customer.infrastructure.mapper;

import com.andre.ecommerce.customer.domain.Customer;
import com.andre.ecommerce.customer.domain.CustomerAddress;
import com.andre.ecommerce.customer.infrastructure.dto.CustomerAddressDTO;
import com.andre.ecommerce.customer.infrastructure.dto.CustomerCreateDTO;

public class CustomerAddressMapper {

    public static CustomerAddress toDomain(CustomerAddressDTO dto) {
        if (dto == null) {
            return null;
        }

        return new CustomerAddress(
                dto.department(),
                dto.province(),
                dto.district(),
                dto.postalCode(),
                dto.streetType(),
                dto.streetName(),
                dto.streetNumber(),
                dto.floorApartment(),
                dto.reference()
        );
    }
}

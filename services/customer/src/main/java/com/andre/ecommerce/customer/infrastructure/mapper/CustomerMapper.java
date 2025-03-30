package com.andre.ecommerce.customer.infrastructure.mapper;

import com.andre.ecommerce.customer.domain.Customer;
import com.andre.ecommerce.customer.domain.CustomerAddress;
import com.andre.ecommerce.customer.infrastructure.dto.CustomerCreateDTO;
import com.andre.ecommerce.customer.infrastructure.persistence.CustomerDocument;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    // DTO -> domain model
    public Customer toDomain(CustomerCreateDTO dto) {
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

    public CustomerDocument toDocument(Customer customer) {
        if (customer == null) {
            return null;
        }

        return CustomerDocument.builder()
                .id(customer.getId())
                .birthDate(customer.getBirthdate())
                .email(customer.getEmail())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .build();
    }

    public Customer toDomain(CustomerDocument customerDocument) {
    }
}

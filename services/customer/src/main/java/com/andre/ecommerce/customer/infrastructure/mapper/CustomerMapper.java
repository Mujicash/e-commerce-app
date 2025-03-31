package com.andre.ecommerce.customer.infrastructure.mapper;

import com.andre.ecommerce.customer.domain.Customer;
import com.andre.ecommerce.customer.domain.CustomerAddress;
import com.andre.ecommerce.customer.infrastructure.dto.CustomerCreateDTO;
import com.andre.ecommerce.customer.infrastructure.persistence.CustomerAddressDocument;
import com.andre.ecommerce.customer.infrastructure.persistence.CustomerDocument;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class CustomerMapper {

    private final CustomerAddressMapper addressMapper;

    // DTO -> domain model
    public Customer toDomain(CustomerCreateDTO dto) {
        if (dto == null) {
            return null;
        }

        CustomerAddress address = null;

        if (dto.address() != null) {
            address = addressMapper.toDomain(dto.address());
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
                .addresses(
                        customer.getAddresses() != null && !customer.getAddresses().isEmpty()
                                ? List.of()
                                : customer.getAddresses().stream().map(addressMapper::toDocument).toList()
                )
                .build();
    }

    public Customer toDomain(CustomerDocument customerDocument) {
        if (customerDocument == null) {
            return null;
        }

        List<CustomerAddress> addresses;

        if (customerDocument.getAddresses() != null && !customerDocument.getAddresses().isEmpty()) {
            addresses = customerDocument.getAddresses().stream().map(addressMapper::toDomain).toList();
        }
        else {
            addresses = List.of();
        }

        return Customer.restore(
                customerDocument.getId(),
                customerDocument.getBirthDate(),
                customerDocument.getEmail(),
                customerDocument.getFirstName(),
                customerDocument.getLastName(),
                addresses
        );
    }
}

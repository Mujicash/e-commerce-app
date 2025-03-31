package com.andre.ecommerce.customer.infrastructure.mapper;

import com.andre.ecommerce.customer.domain.Customer;
import com.andre.ecommerce.customer.domain.CustomerAddress;
import com.andre.ecommerce.customer.infrastructure.dto.CustomerAddressDTO;
import com.andre.ecommerce.customer.infrastructure.dto.CustomerCreateDTO;
import com.andre.ecommerce.customer.infrastructure.persistence.CustomerAddressDocument;
import org.springframework.stereotype.Component;

@Component
public class CustomerAddressMapper {

    public CustomerAddress toDomain(CustomerAddressDTO dto) {
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

    public CustomerAddress toDomain(CustomerAddressDocument addressDocument) {
        if (addressDocument == null) {
            return null;
        }

        return new CustomerAddress(
                addressDocument.getDepartment(),
                addressDocument.getProvince(),
                addressDocument.getDistrict(),
                addressDocument.getPostalCode(),
                addressDocument.getStreetType(),
                addressDocument.getStreetName(),
                addressDocument.getStreetNumber(),
                addressDocument.getFloorApartment(),
                addressDocument.getReference()
        );
    }

    public CustomerAddressDocument toDocument(CustomerAddress address) {
        if (address == null) {
            return null;
        }

        return CustomerAddressDocument.builder()
                .department(address.getDepartment())
                .province(address.getProvince())
                .district(address.getDistrict())
                .postalCode(address.getPostalCode())
                .streetType(address.getStreetType())
                .streetName(address.getStreetName())
                .streetNumber(address.getStreetNumber())
                .floorApartment(address.getFloorApartment())
                .reference(address.getReference())
                .build();
    }
}

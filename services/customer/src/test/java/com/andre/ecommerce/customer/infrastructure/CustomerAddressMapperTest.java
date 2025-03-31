package com.andre.ecommerce.customer.infrastructure;

import com.andre.ecommerce.customer.domain.CustomerAddress;
import com.andre.ecommerce.customer.infrastructure.dto.CustomerAddressDTO;
import com.andre.ecommerce.customer.infrastructure.mapper.CustomerAddressMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CustomerAddressMapperTest {

    private final CustomerAddressMapper customerAddressMapper = new CustomerAddressMapper();

    @Test
    public void testToDomain() {
        CustomerAddressDTO addressDTO = new CustomerAddressDTO(
                "Lima",
                "Lima",
                "San Miguel",
                "15253",
                "Avenida",
                "La Libertad",
                1501,
                "405A",
                "Condominio de la Esquina"
        );

        CustomerAddress customerAddress = customerAddressMapper.toDomain(addressDTO);

        assertNotNull(customerAddress);
        assertEquals(addressDTO.department(), customerAddress.getDepartment());
        assertEquals(addressDTO.province(), customerAddress.getProvince());
        assertEquals(addressDTO.district(), customerAddress.getDistrict());
        assertEquals(addressDTO.postalCode(), customerAddress.getPostalCode());
        assertEquals(addressDTO.streetType(), customerAddress.getStreetType());
        assertEquals(addressDTO.streetName(), customerAddress.getStreetName());
        assertEquals(addressDTO.streetNumber(), customerAddress.getStreetNumber());
        assertEquals(addressDTO.floorApartment(), customerAddress.getFloorApartment());
        assertEquals(addressDTO.reference(), customerAddress.getReference());
    }
}

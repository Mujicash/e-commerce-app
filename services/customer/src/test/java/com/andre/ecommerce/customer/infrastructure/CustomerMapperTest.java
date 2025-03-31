package com.andre.ecommerce.customer.infrastructure;

import com.andre.ecommerce.customer.domain.Customer;
import com.andre.ecommerce.customer.domain.CustomerAddress;
import com.andre.ecommerce.customer.infrastructure.dto.CustomerAddressDTO;
import com.andre.ecommerce.customer.infrastructure.dto.CustomerCreateDTO;
import com.andre.ecommerce.customer.infrastructure.mapper.CustomerAddressMapper;
import com.andre.ecommerce.customer.infrastructure.mapper.CustomerMapper;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerMapperTest {

    private final CustomerMapper customerMapper = new CustomerMapper(new CustomerAddressMapper());

    @Test
    public void testToDomainWithAddress() {
        LocalDate birthdate = LocalDate.of(2001, 1, 27);
        String email = "andre271@gmail.com";
        String firstName = "Andre";
        String lastName = "Mujica";
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
        CustomerCreateDTO customerCreateDTO = new CustomerCreateDTO(
                birthdate,
                email,
                firstName,
                lastName,
                addressDTO
        );
        Customer customer = customerMapper.toDomain(customerCreateDTO);

        assertNotNull(customer);
        assertNotNull(customer.getId());
        assertEquals(email, customer.getEmail());
        assertEquals(firstName, customer.getFirstName());
        assertEquals(lastName, customer.getLastName());

        List<CustomerAddress> addresses = customer.getAddresses();
        assertNotNull(addresses);
        assertEquals(1, addresses.size());

        CustomerAddress customerAddress = addresses.getFirst();
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

    @Test
    public void testToDomainWithoutAddress() {
        LocalDate birthdate = LocalDate.of(2001, 1, 27);
        String email = "andre271@gmail.com";
        String firstName = "Andre";
        String lastName = "Mujica";
        CustomerCreateDTO customerCreateDTO = new CustomerCreateDTO(
                birthdate,
                email,
                firstName,
                lastName,
                null
        );
        Customer customer = customerMapper.toDomain(customerCreateDTO);

        assertNotNull(customer);
        assertNotNull(customer.getId());
        assertEquals(email, customer.getEmail());
        assertEquals(firstName, customer.getFirstName());
        assertEquals(lastName, customer.getLastName());

        List<CustomerAddress> addresses = customer.getAddresses();
        assertNotNull(addresses);
        assertEquals(0, addresses.size());
    }

    @Test
    public void testToDomainWithNullDTO() {
        CustomerCreateDTO dto = null;
        Customer customer = customerMapper.toDomain(dto);

        assertNull(customer);
    }
}

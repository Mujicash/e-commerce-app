package com.andre.ecommerce.customer.domain;

import com.andre.ecommerce.shared.domain.InvalidValueException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerAddressTest {

    @Test
    public void testCustomerAddressCreationValid() {
        CustomerAddress address = new CustomerAddress(
                "Lima",
                "Lima",
                "San Miguel",
                "15253",
                "Avenida",
                "La Libertad",
                250,
                "105",
                "Cerca al parque"
        );

        assertEquals("Lima", address.getDepartment());
        assertEquals("Lima", address.getProvince());
        assertEquals("San Miguel", address.getDistrict());
        assertEquals("15253", address.getPostalCode());
        assertEquals("Avenida", address.getStreetType());
        assertEquals("La Libertad", address.getStreetName());
        //assertTrue(address.getStreetNumber().isPresent());
        assertEquals(250, address.getStreetNumber());
        //assertTrue(address.getFloorApartment().isPresent());
        assertEquals("105", address.getFloorApartment());
        //assertTrue(address.getReference().isPresent());
        assertEquals("Cerca al parque", address.getReference());
    }

    @Test
    public void testInvalidPostalCode() {
        Exception exception = assertThrows(InvalidValueException.class, () -> {
            new CustomerAddress(
                    "Lima",
                    "Lima",
                    "San Miguel",
                    "1234", // postal code inválido: no tiene 5 dígitos
                    "Avenida",
                    "La Libertad",
                    250,
                    "105",
                    "Cerca al parque"
            );
        });
        assertTrue(exception.getMessage().contains("Invalid postal code"));
    }

    @Test
    public void testEquality() {
        CustomerAddress address1 = new CustomerAddress(
                "Lima", "Lima", "San Miguel", "15253", "Avenida", "La Libertad", 250, "105", "Cerca al parque"
        );
        CustomerAddress address2 = new CustomerAddress(
                "Lima", "Lima", "San Miguel", "15253", "Avenida", "La Libertad", 250, "105", "Cerca al parque"
        );

        // Se espera que sean iguales ya que todos sus VO son iguales.
        assertEquals(address1, address2);
        assertEquals(address1.hashCode(), address2.hashCode());
    }

    @Test
    public void testOptionalValuesNotPresent() {
        CustomerAddress address = new CustomerAddress(
                "Lima",       // department
                "Lima",       // province
                "San Miguel", // district
                "15253",      // postalCode
                "Avenida",    // streetType
                "La Libertad",// streetName
                null,         // streetNumber
                null,         // floorApartment
                null          // reference
        );

        assertNull(address.getStreetNumber(), "Expected streetNumber to be null when not provided");
        assertNull(address.getFloorApartment(), "Expected floorApartment to be null when not provided");
        assertNull(address.getReference(), "Expected reference to be null when not provided");
    }
}

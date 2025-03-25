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

        assertEquals("Lima", address.getDepartment().getValue());
        assertEquals("Lima", address.getProvince().getValue());
        assertEquals("San Miguel", address.getDistrict().getValue());
        assertEquals("15253", address.getPostalCode().getValue());
        assertEquals("Avenida", address.getStreetType().getValue());
        assertEquals("La Libertad", address.getStreetName().getValue());
        assertTrue(address.getStreetNumber().isPresent());
        assertEquals(250, address.getStreetNumber().get().getValue());
        assertTrue(address.getFloorApartment().isPresent());
        assertEquals("105", address.getFloorApartment().get().getValue());
        assertTrue(address.getReference().isPresent());
        assertEquals("Cerca al parque", address.getReference().get());
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
}

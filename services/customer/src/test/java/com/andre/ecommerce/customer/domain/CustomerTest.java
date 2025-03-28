package com.andre.ecommerce.customer.domain;

import com.andre.ecommerce.shared.domain.InvalidValueException;
import com.andre.ecommerce.shared.domain.UuidValueObject;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @Test
    public void testValidCustomerCreationWithAddress() {
        // Se construye un CustomerAddress previamente (su construcción ya realiza las validaciones correspondientes)
        CustomerAddress address = new CustomerAddress(
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

        // Se crea el Customer con datos válidos
        Customer customer = Customer.create(
                LocalDate.of(2001,1,27),
                "andre27012001@gmail.com",
                "Andre",
                "Mujica",
                address
        );

        // Verificar que los VO internos se hayan creado correctamente a partir de las primitivas
        assertNotNull(customer);
        assertNotNull(customer.getId());
        assertNotNull(customer.getBirthdate());
        assertNotNull(customer.getEmail());
        assertNotNull(customer.getAddresses());

        //assertEquals(userId, customer.getId());
        assertEquals(LocalDate.of(2001, 1, 27), customer.getBirthdate());
        assertEquals("andre27012001@gmail.com", customer.getEmail());
        // Para la dirección, se compara usando equals, que a su vez debe delegar en los VO internos
        assertEquals(1, customer.getAddresses().size());
        assertEquals(address, customer.getAddresses().getFirst());
    }

    @Test
    public void testCreateCustomerWithoutAddress() {
        // Crear Customer sin dirección (lista vacía)
        Customer customer = Customer.create(
                LocalDate.of(2001,1,27),
                "andre27012001@gmail.com",
                "Andre",
                "Mujica",
                null
        );

        //assertEquals(userId, customer.getId());
        assertNotNull(customer.getId());
        assertEquals(LocalDate.of(2001, 1, 27), customer.getBirthdate());
        assertEquals("andre27012001@gmail.com", customer.getEmail());
        // Verificar que la lista de direcciones está vacía
        assertNotNull(customer.getAddresses());
        assertTrue(customer.getAddresses().isEmpty());
    }

    @Test
    public void testInvalidEmail() {
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

        // Se espera que al pasar un email inválido se lance una excepción
        Exception exception = assertThrows(InvalidValueException.class, () -> {
            Customer.create(
                    LocalDate.of(2001,1,27),
                    "andre27012001@yahoo.com",
                    "Andre",
                    "Mujica",
                    address
            );
        });
        // Se puede validar que el mensaje contenga una pista, si el mensaje es significativo
        //String message = exception.getMessage();
        //assertNotNull(message);
        assertTrue(exception.getMessage().contains("Invalid email address"));
    }

    @Test
    public void testEqualityOfCustomers() {
        CustomerAddress address1 = new CustomerAddress(
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

        Customer customer1 = Customer.create(
                LocalDate.of(1990, 1, 1),
                "andre271@gmail.com",
                "Andre",
                "Mujica",
                address1
        );
        Customer customer2 = Customer.restore(
                customer1.getId(),
                customer1.getBirthdate(),
                customer1.getEmail(),
                customer1.getFirstName(),
                customer1.getLastName(),
                customer1.getAddresses()
        );

        // Si se ha sobrescrito equals y hashCode (ya sea manualmente o con Lombok) en Customer y en sus VO,
        // se espera que dos customers con los mismos valores sean considerados iguales.
        assertEquals(customer1, customer2);
        assertEquals(customer1.hashCode(), customer2.hashCode());
    }
}

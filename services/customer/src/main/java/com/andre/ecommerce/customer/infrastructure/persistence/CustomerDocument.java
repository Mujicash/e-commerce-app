package com.andre.ecommerce.customer.infrastructure.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collation = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDocument {
    @Id
    private String id;
    private String email;
    private LocalDate birthDate;
    private CustomerAddressDocument address;
}

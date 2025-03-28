package com.andre.ecommerce.customer.infrastructure.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collation = "customers")
@Data
@Builder
public class CustomerDocument {
    @Id
    private String id;
    private String email;
    private LocalDate birthDate;
    private String firstName;
    private String lastName;
    private List<CustomerAddressDocument> addresses;
}

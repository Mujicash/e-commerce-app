package com.andre.ecommerce.customer.infrastructure.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class CustomerAddressDocument {
    private String department;
    private String province;
    private String district;
    private String postalCode;
    private String streetType;
    private String streetName;
    private Integer streetNumber;
    private String floorApartment;
    private String reference;
}

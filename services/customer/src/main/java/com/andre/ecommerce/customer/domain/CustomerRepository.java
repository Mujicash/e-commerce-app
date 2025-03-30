package com.andre.ecommerce.customer.domain;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
    Customer save (Customer customer);
    Optional<Customer> findById(String id);
    Optional<Customer> findByEmail(String email);
    List<Customer> findAllCustomers();
    Boolean deleteById(String id);
}

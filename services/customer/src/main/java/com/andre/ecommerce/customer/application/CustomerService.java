package com.andre.ecommerce.customer.application;

import com.andre.ecommerce.customer.domain.Customer;
import com.andre.ecommerce.customer.domain.CustomerRepository;
import com.andre.ecommerce.customer.infrastructure.dto.CustomerCreateDTO;
import com.andre.ecommerce.customer.infrastructure.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public String createCustomer(CustomerCreateDTO customerCreateDTO) {
        Customer customer = customerMapper.toDomain(customerCreateDTO);
        // some business logic
        //customer = customerRepository.save(customer);
    }

}

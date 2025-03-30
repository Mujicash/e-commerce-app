package com.andre.ecommerce.customer.infrastructure.persistence;

import com.andre.ecommerce.customer.domain.Customer;
import com.andre.ecommerce.customer.domain.CustomerRepository;
import com.andre.ecommerce.customer.infrastructure.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MongoCustomerRepository implements CustomerRepository {

    private final CustomerDocumentMongoRepository mongoRepository;
    private final CustomerMapper customerMapper;

    @Autowired
    public MongoCustomerRepository(
            CustomerDocumentMongoRepository mongoRepository,
            CustomerMapper customerMapper
    ) {
        this.mongoRepository = mongoRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public Customer save(Customer customer) {
        CustomerDocument customerDocument = customerMapper.toDocument(customer);
        customerDocument = mongoRepository.save(customerDocument);
        return customerMapper.toDomain(customerDocument);
    }

    @Override
    public Optional<Customer> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public List<Customer> findAllCustomers() {
        return List.of();
    }

    @Override
    public Boolean deleteById(String id) {
        return null;
    }
}

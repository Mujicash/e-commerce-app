package com.andre.ecommerce.customer.infrastructure.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerDocumentMongoRepository extends MongoRepository<CustomerDocument, String> {
}

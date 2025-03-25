package com.andre.ecommerce.customer;

import com.andre.ecommerce.customer.domain.CustomerEmail;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerApplication {

	public static void main(String[] args) {
		//SpringApplication.run(CustomerApplication.class, args);
		CustomerEmail email = new CustomerEmail("andre2701@gmail.com");
	}

}

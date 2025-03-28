package com.andre.ecommerce.customer;

import com.andre.ecommerce.customer.domain.Customer;
import com.andre.ecommerce.customer.domain.CustomerAddress;
import com.andre.ecommerce.customer.domain.CustomerEmail;
import com.andre.ecommerce.shared.domain.UuidValueObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class CustomerApplication {

	public static void main(String[] args) {
		//SpringApplication.run(CustomerApplication.class, args);
		CustomerAddress address = new CustomerAddress("a", "a", "a", "12345", "a", "a", 1, "405a", "a");
		CustomerAddress address2 = null;
		System.out.println(address);
		System.out.println(address2);
		var address_list = List.of(address);
		var address_lis2 = address2 != null ? List.of(address2) : List.of();
		System.out.println(address_list);
		System.out.println(address_lis2);

		String id = UuidValueObject.create().getValue();
		Customer customer = Customer.create(
				LocalDate.of(1990, 1, 1),
				"andre271@gmail.com",
				"Andre",
				"Mujica",
				address2
		);
		System.out.println(customer);
	}

}

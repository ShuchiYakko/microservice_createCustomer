package com.amigoscode.customer.service;

import com.amigoscode.customer.CustomerRepository;
import com.amigoscode.customer.Model.Customer;
import com.amigoscode.customer.Model.CustomerRegistrationRequest;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository) {
    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {

        Customer customer= Customer.builder()
                .firstName(customerRegistrationRequest.firstName())
                .lastName(customerRegistrationRequest.lastName())
                .email(customerRegistrationRequest.email())
                .build();

        // check for validity email and name

        customerRepository.save(customer);
    }
}

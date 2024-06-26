package com.amigoscode.customer.service;

import com.amigoscode.customer.CustomerRepository;
import com.amigoscode.customer.FraudCheckResponse;
import com.amigoscode.customer.Model.Customer;
import com.amigoscode.customer.Model.CustomerRegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {

        Customer customer= Customer.builder()
                .firstName(customerRegistrationRequest.firstName())
                .lastName(customerRegistrationRequest.lastName())
                .email(customerRegistrationRequest.email())
                .build();

        customerRepository.saveAndFlush(customer);//otherwise customerId will be null

        // check for validity email and name

        FraudCheckResponse fraudCheckResponse =
                restTemplate.getForObject(
                "http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,customer.getId()
        );

        if(fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("fraudster");
        }

    }
}

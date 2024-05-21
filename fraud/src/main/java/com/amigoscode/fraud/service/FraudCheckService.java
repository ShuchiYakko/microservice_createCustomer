package com.amigoscode.fraud.service;

import com.amigoscode.fraud.FraudCheckHistory;
import com.amigoscode.fraud.jpa.FraudCheckHistoryRepository;
import com.fasterxml.jackson.core.PrettyPrinter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public boolean isFraudulentCustomer(Integer customerID){
    fraudCheckHistoryRepository.save(
            FraudCheckHistory.builder()
                    .customerId(customerID)
                    .createAt(LocalDateTime.now())
                    .isFraudster(false)
                    .build()
    );
    return false;
    }
}

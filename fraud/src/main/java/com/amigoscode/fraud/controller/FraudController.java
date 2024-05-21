package com.amigoscode.fraud.controller;

import com.amigoscode.fraud.service.FraudCheckService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
public class FraudController {

    private final FraudCheckService fraudCheckService;

    public FraudController(FraudCheckService fraudCheckService) {
        this.fraudCheckService = fraudCheckService;
    }

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(
            @PathVariable ("customerId") Integer customerID ){
        boolean fraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerID);
        return new FraudCheckResponse(fraudulentCustomer);
    }
}

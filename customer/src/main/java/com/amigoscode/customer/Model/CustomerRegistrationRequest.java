package com.amigoscode.customer.Model;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email)
{
}

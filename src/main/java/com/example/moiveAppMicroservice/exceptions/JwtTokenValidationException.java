package com.example.moiveAppMicroservice.exceptions;

public class JwtTokenValidationException extends RuntimeException {
    public JwtTokenValidationException(String message) {
        super(message);
    }
}

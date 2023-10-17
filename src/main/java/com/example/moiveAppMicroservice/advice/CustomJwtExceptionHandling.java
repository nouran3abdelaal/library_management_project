package com.example.moiveAppMicroservice.advice;

import com.example.moiveAppMicroservice.exceptions.JwtTokenValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomJwtExceptionHandling {

    @ExceptionHandler(JwtTokenValidationException.class)
    public ResponseEntity<String> handleJwtTokenValidationException(JwtTokenValidationException ex) {
        System.out.println("Handling JwtTokenValidationException: {}  "+ ex.getMessage());

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
//        return ResponseEntity.noContent().build();

    }
}

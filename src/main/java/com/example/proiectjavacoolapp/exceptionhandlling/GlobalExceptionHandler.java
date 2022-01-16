package com.example.proiectjavacoolapp.exceptionhandlling;

import com.example.proiectjavacoolapp.exceptions.QuantityLowerThen50Exception;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleException(MethodArgumentNotValidException exception){
        Map<String, String> responseParameters = new HashMap<>();
        responseParameters.put("Reason: ", exception.getMessage());
        responseParameters.put("DateTime: ", LocalDateTime.now().toString());

        return ResponseEntity.badRequest().body(responseParameters);
    }
}

package com.rahulpateldev.exceptions;

import com.rahulpateldev.exceptions.custom.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public record ApiError(String message, String error, HttpStatus status, int code) {
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleResourceNotFoundException(ResourceNotFoundException ex) {
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(
                new ApiError(
                        "Resource not found!!",
                        ex.getLocalizedMessage(),
                        notFound,
                        notFound.value()
                ), notFound
        );
    }
}

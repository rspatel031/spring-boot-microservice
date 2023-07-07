package com.rahulpateldev.exceptions;

import com.rahulpateldev.exceptions.custom.IDNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public record ApiError(String message, String error, HttpStatus status, int statusCode) {
    }

    @ExceptionHandler(IDNotFoundException.class)
    public ResponseEntity<ApiError> handleIDNotFoundException(IDNotFoundException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(
                new ApiError("Resource Not Found!!",
                        ex.getLocalizedMessage(),
                        status,
                        status.value()),
                status);
    }

}

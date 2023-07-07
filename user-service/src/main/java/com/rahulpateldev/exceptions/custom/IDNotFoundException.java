package com.rahulpateldev.exceptions.custom;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IDNotFoundException extends RuntimeException {

    public IDNotFoundException() {
        super("ID not found on server!!");
    }

    public IDNotFoundException(String message) {
        super(message);
    }
}

package com.github.alissonmartineli.contactmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ContactNotFoundException extends Exception {

    public ContactNotFoundException(Long id) {
        super(String.format("Person with ID %s not found!", id));
    }
}

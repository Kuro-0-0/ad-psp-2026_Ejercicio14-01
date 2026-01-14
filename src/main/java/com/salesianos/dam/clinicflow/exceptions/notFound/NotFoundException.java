package com.salesianos.dam.clinicflow.exceptions.notFound;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}

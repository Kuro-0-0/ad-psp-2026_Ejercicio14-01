package com.salesianos.dam.clinicflow.exceptions.notFound;

public class CitaNotFoundException extends NotFoundException {
    public CitaNotFoundException(String message) {
        super(message);
    }
    public CitaNotFoundException(Long id) {
        super("Cita con id " + id + " no encontrado.");
    }
}

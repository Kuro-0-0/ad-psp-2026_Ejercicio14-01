package com.salesianos.dam.clinicflow.exceptions.notFound;

public class CitaNotFound extends RuntimeException {
    public CitaNotFound(String message) {
        super(message);
    }
    public CitaNotFound(Long id) {
        super("Cita con id " + id + " no encontrado.");
    }
}

package com.salesianos.dam.clinicflow.exceptions.notFound;

public class ProfesionalNotFound extends RuntimeException {
    public ProfesionalNotFound(String message) {
        super(message);
    }
    public ProfesionalNotFound(Long id) {
        super("Profesional con id " + id + " no encontrado.");
    }
}

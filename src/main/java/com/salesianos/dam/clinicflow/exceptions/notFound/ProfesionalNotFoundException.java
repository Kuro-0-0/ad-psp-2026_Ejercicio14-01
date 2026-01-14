package com.salesianos.dam.clinicflow.exceptions.notFound;

public class ProfesionalNotFoundException extends NotFoundException {
    public ProfesionalNotFoundException(String message) {
        super(message);
    }
    public ProfesionalNotFoundException(Long id) {
        super("Profesional con id " + id + " no encontrado.");
    }
}

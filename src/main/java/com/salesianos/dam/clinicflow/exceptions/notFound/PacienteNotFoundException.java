package com.salesianos.dam.clinicflow.exceptions.notFound;

public class PacienteNotFoundException extends NotFoundException {
    public PacienteNotFoundException(String message) {
        super(message);
    }
    public PacienteNotFoundException(Long id) {
        super("Paciente con id " + id + " no encontrado.");
    }
}

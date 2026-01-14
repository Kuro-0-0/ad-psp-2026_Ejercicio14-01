package com.salesianos.dam.clinicflow.exceptions.notFound;

public class PacienteNotFound extends RuntimeException {
    public PacienteNotFound(String message) {
        super(message);
    }
    public PacienteNotFound(Long id) {
        super("Paciente con id " + id + " no encontrado.");
    }
}

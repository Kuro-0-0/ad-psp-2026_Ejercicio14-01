package com.salesianos.dam.clinicflow.exceptions.notFound;

public class ConsultaNotFoundException extends NotFoundException {
    public ConsultaNotFoundException(String message) {
        super(message);
    }
    public ConsultaNotFoundException(Long id) {
        super("Consulta con id " + id + " no encontrado.");
    }
}

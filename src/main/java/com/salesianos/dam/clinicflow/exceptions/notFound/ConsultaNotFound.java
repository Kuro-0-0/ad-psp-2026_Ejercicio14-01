package com.salesianos.dam.clinicflow.exceptions.notFound;

public class ConsultaNotFound extends RuntimeException {
    public ConsultaNotFound(String message) {
        super(message);
    }
    public ConsultaNotFound(Long id) {
        super("Consulta con id " + id + " no encontrado.");
    }
}

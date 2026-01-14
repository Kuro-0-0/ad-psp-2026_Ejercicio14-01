package com.salesianos.dam.clinicflow.exceptions;

public class AlreadyCanceledException extends BadArgumentsException {
    public AlreadyCanceledException() {
        super("No se puede cancelar una cita que ya está cancelada.");
    }
}

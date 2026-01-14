package com.salesianos.dam.clinicflow.entities.extra.DTOs.paciente;

import com.salesianos.dam.clinicflow.entities.Paciente;

public record PacienteResponseDTO(String nombre, String email, String fechaNacimiento){

    public static PacienteResponseDTO to(Paciente p) {
        return new PacienteResponseDTO(
                p.getNombre(),
                p.getEmail(),
                p.getFechaNacimiento().toString()
        );
    }

};
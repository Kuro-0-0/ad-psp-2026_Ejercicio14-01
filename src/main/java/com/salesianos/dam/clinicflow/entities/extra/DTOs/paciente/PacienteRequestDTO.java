package com.salesianos.dam.clinicflow.entities.extra.DTOs.paciente;

import com.salesianos.dam.clinicflow.entities.Paciente;

public record PacienteRequestDTO(String nombre, String email, String fechaNacimiento){

    public Paciente from() {
        return Paciente.builder()
                .nombre(this.nombre)
                .email(this.email)
                .fechaNacimiento(java.time.LocalDate.parse(this.fechaNacimiento))
                .build();
    }

};
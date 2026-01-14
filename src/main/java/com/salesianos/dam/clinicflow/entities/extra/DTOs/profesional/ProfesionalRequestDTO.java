package com.salesianos.dam.clinicflow.entities.extra.DTOs.profesional;

import com.salesianos.dam.clinicflow.entities.Paciente;
import com.salesianos.dam.clinicflow.entities.Profesional;

public record ProfesionalRequestDTO(String nombre, String especialidad){

    public Profesional from() {
        return Profesional.builder()
                .nombre(this.nombre)
                .especialidad(this.especialidad)
                .build();
    }

};
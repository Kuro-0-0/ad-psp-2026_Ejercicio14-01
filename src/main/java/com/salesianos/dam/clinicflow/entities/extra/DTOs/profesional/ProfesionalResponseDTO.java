package com.salesianos.dam.clinicflow.entities.extra.DTOs.profesional;

import com.salesianos.dam.clinicflow.entities.Paciente;
import com.salesianos.dam.clinicflow.entities.Profesional;

public record ProfesionalResponseDTO(String nombre, String especialidad){

    public static ProfesionalResponseDTO to(Profesional p) {
        return new ProfesionalResponseDTO(
                p.getNombre(),
                p.getEspecialidad()
        );
    }

};
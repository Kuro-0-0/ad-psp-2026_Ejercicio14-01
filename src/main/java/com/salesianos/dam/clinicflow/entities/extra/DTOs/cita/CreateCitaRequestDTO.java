package com.salesianos.dam.clinicflow.entities.extra.DTOs.cita;

import com.salesianos.dam.clinicflow.entities.Cita;
import com.salesianos.dam.clinicflow.entities.Consulta;
import com.salesianos.dam.clinicflow.entities.Paciente;
import com.salesianos.dam.clinicflow.entities.Profesional;
import com.salesianos.dam.clinicflow.entities.extra.Estado;

import java.time.LocalDateTime;

public record CreateCitaRequestDTO(
        String fechaHora,
        String estado,
        Long profesionalId,
        Long pacienteId,
        Long consultaId
) {

    public Cita from() {
        return Cita.builder()
                .fechaHora(LocalDateTime.parse(this.fechaHora))
                .estado(Estado.valueOf(this.estado))
                .profesional(Profesional.builder().id(profesionalId).build())
                .paciente(Paciente.builder().id(pacienteId).build())
                .consulta(Consulta.builder().id(consultaId).build())
                .build();
    }


}

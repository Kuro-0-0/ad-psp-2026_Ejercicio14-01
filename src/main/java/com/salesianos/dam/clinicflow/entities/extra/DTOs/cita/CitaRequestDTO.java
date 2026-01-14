package com.salesianos.dam.clinicflow.entities.extra.DTOs.cita;

import com.salesianos.dam.clinicflow.entities.Cita;
import com.salesianos.dam.clinicflow.entities.Consulta;
import com.salesianos.dam.clinicflow.entities.Paciente;
import com.salesianos.dam.clinicflow.entities.Profesional;
import com.salesianos.dam.clinicflow.entities.extra.Estado;
import com.salesianos.dam.clinicflow.services.ConsultaService;
import com.salesianos.dam.clinicflow.services.PacienteService;
import com.salesianos.dam.clinicflow.services.ProfesionalService;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

public record CitaRequestDTO(
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

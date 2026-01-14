package com.salesianos.dam.clinicflow.entities.extra.DTOs.cita;

import com.salesianos.dam.clinicflow.entities.Cita;
import com.salesianos.dam.clinicflow.entities.Consulta;
import com.salesianos.dam.clinicflow.entities.Paciente;
import com.salesianos.dam.clinicflow.entities.Profesional;
import com.salesianos.dam.clinicflow.entities.extra.DTOs.consulta.ConsultaResponseDTO;
import com.salesianos.dam.clinicflow.entities.extra.DTOs.paciente.PacienteResponseDTO;
import com.salesianos.dam.clinicflow.entities.extra.DTOs.profesional.ProfesionalResponseDTO;

public record CitaResponseDTO(
        String fechaHora,
        String estado,
        ProfesionalResponseDTO profesional,
        PacienteResponseDTO paciente,
        ConsultaResponseDTO consulta
) {

    public static CitaResponseDTO to(Cita cita){
        return new CitaResponseDTO(
                cita.getFechaHora().toString(),
                cita.getEstado().name(),
                ProfesionalResponseDTO.to(cita.getProfesional()),
                PacienteResponseDTO.to(cita.getPaciente()),
                ConsultaResponseDTO.to(cita.getConsulta())
        );
    }

}

package com.salesianos.dam.clinicflow.entities.extra.DTOs.consulta;

import com.salesianos.dam.clinicflow.entities.Consulta;

import java.time.LocalDate;

public record ConsultaResponseDTO(String observaciones, String diagnostico, String fecha) {

    public static ConsultaResponseDTO to(Consulta consulta){
        return new ConsultaResponseDTO(
                consulta.getObservaciones(),
                consulta.getDiagnostico(),
                consulta.getFecha().toString()
        );
    }

}

package com.salesianos.dam.clinicflow.entities.extra.DTOs.consulta;

import com.salesianos.dam.clinicflow.entities.Consulta;

import java.time.LocalDate;

public record CreateConsultaRequestDTO(
        String observaciones,
        String diagnostico,
        String fecha
) {

    public Consulta from() {
        return Consulta.builder()
                .observaciones(this.observaciones)
                .diagnostico(this.diagnostico)
                .fecha(LocalDate.parse(this.fecha))
                .build();
    }

}

package com.salesianos.dam.clinicflow.entities.extra.DTOs.consulta;

import com.salesianos.dam.clinicflow.entities.Consulta;

import java.time.LocalDate;

public record ConsultaRequestDTO (String observaciones, String diagnostico, String fecha) {

    public Consulta from() {
        return Consulta.builder()
                .diagnostico(this.diagnostico)
                .observaciones(this.observaciones)
                .fecha(LocalDate.parse(this.fecha))
                .build();
    }

}

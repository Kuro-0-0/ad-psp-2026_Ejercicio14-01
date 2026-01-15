package com.salesianos.dam.clinicflow.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor @NoArgsConstructor
@ToString @Getter @Setter
@Builder
public class Consulta {

    @Id @GeneratedValue
    private Long id;

    private String observaciones;
    private String diagnostico;
    private LocalDate fecha;

    public Consulta modify(Consulta c) {
        return Consulta.builder()
                .id(this.id)
                .observaciones(c.getObservaciones())
                .diagnostico(c.getDiagnostico())
                .fecha(c.getFecha())
                .build();
    }
}

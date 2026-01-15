package com.salesianos.dam.clinicflow.entities;

import com.salesianos.dam.clinicflow.entities.extra.Estado;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor @NoArgsConstructor
@ToString @Getter @Setter
@Builder
public class Cita {

    @Id @GeneratedValue
    private Long id;
    private LocalDateTime fechaHora;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @ManyToOne
    private Paciente paciente;
    @ManyToOne
    private Profesional profesional;
    @OneToOne
    private Consulta consulta;

    public Cita modify(Cita c) {
        return Cita.builder()
                .id(this.id)
                .fechaHora(c.getFechaHora())
                .estado(c.getEstado())
                .paciente(c.getPaciente())
                .profesional(c.getProfesional())
                .consulta(c.getConsulta())
                .build();
    }
}

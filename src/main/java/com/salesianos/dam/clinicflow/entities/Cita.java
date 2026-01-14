package com.salesianos.dam.clinicflow.entities;

import com.salesianos.dam.clinicflow.entities.extra.Estado;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor @NoArgsConstructor
@ToString @Getter @Setter
@Builder
public class Cita {

    /*
     * id
     * fechaHora
     * estado (PROGRAMADA, CANCELADA, ATENDIDA)
     */

    @Id @GeneratedValue
    private Long id;
    private LocalDateTime fechaHora;

    private Estado estado;

    @ManyToOne
    private Paciente paciente;
}

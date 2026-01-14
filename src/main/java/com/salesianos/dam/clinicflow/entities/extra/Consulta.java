package com.salesianos.dam.clinicflow.entities.extra;

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

    /*
    * id
    * observaciones
    * diagnostico
    * fecha
    * */

    @Id @GeneratedValue
    private Long id;

    private String observaciones;
    private String diagnostico;
    private LocalDate fecha;

}

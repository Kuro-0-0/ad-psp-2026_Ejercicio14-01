package com.salesianos.dam.clinicflow.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor @NoArgsConstructor
@ToString @Getter @Setter
@Builder
public class Profesional {

    /*
    * id
    * nombre
    * especialidad
    * */

    @Id @GeneratedValue
    private Long id;

    private String nombre;
    private String especialidad;

}

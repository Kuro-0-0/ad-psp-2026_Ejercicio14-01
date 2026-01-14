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
public class Paciente {

    /*
    * id
    * nombre
    * email
    * fechaNacimiento
    * */

    @Id @GeneratedValue
    private Long id;

    private String nombre;
    private String email;
    private LocalDate fechaNacimiento;

}

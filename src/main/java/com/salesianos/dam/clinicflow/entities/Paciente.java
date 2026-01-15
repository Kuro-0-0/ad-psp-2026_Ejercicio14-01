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

    @Id @GeneratedValue
    private Long id;

    private String nombre;
    private String email;
    private LocalDate fechaNacimiento;

    public Paciente modify(Paciente p) {
        return Paciente.builder()
                .id(this.id)
                .nombre(p.getNombre())
                .email(p.getEmail())
                .fechaNacimiento(p.getFechaNacimiento())
                .build();
    }
}

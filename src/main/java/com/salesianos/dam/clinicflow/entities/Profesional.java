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

    @Id @GeneratedValue
    private Long id;

    private String nombre;
    private String especialidad;

    public Profesional modify(Profesional p) {
        return Profesional.builder()
                .id(this.id)
                .nombre(p.getNombre())
                .especialidad(p.getEspecialidad())
                .build();
    }
}

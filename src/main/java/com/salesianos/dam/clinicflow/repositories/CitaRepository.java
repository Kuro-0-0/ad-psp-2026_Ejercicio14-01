package com.salesianos.dam.clinicflow.repositories;

import com.salesianos.dam.clinicflow.entities.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitaRepository extends JpaRepository<Cita, Long> {
}

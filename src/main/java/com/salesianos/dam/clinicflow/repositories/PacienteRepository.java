package com.salesianos.dam.clinicflow.repositories;

import com.salesianos.dam.clinicflow.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}

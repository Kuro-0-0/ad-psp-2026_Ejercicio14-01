package com.salesianos.dam.clinicflow.repositories;

import com.salesianos.dam.clinicflow.entities.Cita;
import com.salesianos.dam.clinicflow.entities.Paciente;
import com.salesianos.dam.clinicflow.entities.Profesional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Long> {

    @EntityGraph(attributePaths = {"profesional"})
    @Query(
        "SELECT c FROM Cita c WHERE c.profesional = :profesional"
    )
    List<Cita> findByProfesional(Profesional profesional);

    @EntityGraph(attributePaths = {"profesional"})
    @Query(
        "SELECT c FROM Cita c WHERE c.profesional = :profesional AND c.fechaHora = :fechaHora"
    )
    List<Cita> findByProfesionalAndFechaHora(Profesional profesional, LocalDateTime fechaHora);

    @EntityGraph(attributePaths = {"paciente"})
    @Query( 
        "SELECT c FROM Cita c WHERE c.paciente = :paciente AND c.fechaHora = :fechaHora"
    )
    List<Cita> findByPacienteAndFechaHora(Paciente paciente, LocalDateTime fechaHora);

    List<Cita> findByFechaHoraBetween(LocalDateTime fechaHoraStart, LocalDateTime fechaHoraEnd);


    @EntityGraph(attributePaths = {"paciente"})
    List<Cita> findByPaciente(Paciente paciente);
}

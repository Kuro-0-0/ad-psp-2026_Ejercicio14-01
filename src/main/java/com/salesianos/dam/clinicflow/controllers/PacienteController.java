
package com.salesianos.dam.clinicflow.controllers;

import com.salesianos.dam.clinicflow.entities.Paciente;
import com.salesianos.dam.clinicflow.entities.extra.DTOs.paciente.PacienteRequestDTO;
import com.salesianos.dam.clinicflow.entities.extra.DTOs.paciente.PacienteResponseDTO;
import com.salesianos.dam.clinicflow.services.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService service;

    /* -- CRUD -- */
    @PostMapping()
    public ResponseEntity<PacienteResponseDTO> create(PacienteRequestDTO pacienteRequestDTO) {
        Paciente nuevoPaciente = service.create(pacienteRequestDTO.from());
        return ResponseEntity.status(201).body(PacienteResponseDTO.to(nuevoPaciente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> read(Long id) {
        Paciente paciente = service.read(id);
        return ResponseEntity.ok(PacienteResponseDTO.to(paciente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> update(Long id, PacienteRequestDTO pacienteRequestDTO) {
        Paciente pacienteActualizado = service.update(id, pacienteRequestDTO.from());
        return ResponseEntity.ok(PacienteResponseDTO.to(pacienteActualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    /* -- EXTRAS -- */

    @GetMapping
    public ResponseEntity<List<PacienteResponseDTO>> getAll() {
        return ResponseEntity.ok(
                service.getAll().stream().map(PacienteResponseDTO::to).toList()
        );
    }

}

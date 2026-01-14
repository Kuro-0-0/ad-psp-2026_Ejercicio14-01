
package com.salesianos.dam.clinicflow.controllers;

import com.salesianos.dam.clinicflow.entities.Profesional;
import com.salesianos.dam.clinicflow.entities.extra.DTOs.profesional.ProfesionalRequestDTO;
import com.salesianos.dam.clinicflow.entities.extra.DTOs.profesional.ProfesionalResponseDTO;
import com.salesianos.dam.clinicflow.services.ProfesionalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/profesionales")
public class ProfesionalController {

    private final ProfesionalService service;

    /* -- CRUD -- */
    @PostMapping()
    public ResponseEntity<ProfesionalResponseDTO> create(ProfesionalRequestDTO profesionalRequestDTO) {
        Profesional nuevoProfesional = service.create(profesionalRequestDTO.from());
        return ResponseEntity.status(201).body(ProfesionalResponseDTO.to(nuevoProfesional));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfesionalResponseDTO> read(Long id) {
        Profesional profesional = service.read(id);
        return ResponseEntity.ok(ProfesionalResponseDTO.to(profesional));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfesionalResponseDTO> update(Long id, ProfesionalRequestDTO profesionalRequestDTO) {
        Profesional profesionalActualizado = service.update(id, profesionalRequestDTO.from());
        return ResponseEntity.ok(ProfesionalResponseDTO.to(profesionalActualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    /* -- EXTRAS -- */

    @GetMapping
    public ResponseEntity<List<ProfesionalResponseDTO>> getAll() {
        return ResponseEntity.ok(
                service.getAll().stream().map(ProfesionalResponseDTO::to).toList()
        );
    }

}

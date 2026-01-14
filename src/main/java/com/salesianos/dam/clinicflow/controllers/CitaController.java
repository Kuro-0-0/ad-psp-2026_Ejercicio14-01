
package com.salesianos.dam.clinicflow.controllers;

import com.salesianos.dam.clinicflow.entities.Cita;
import com.salesianos.dam.clinicflow.entities.extra.DTOs.cita.CitaRequestDTO;
import com.salesianos.dam.clinicflow.entities.extra.DTOs.cita.CitaResponseDTO;
import com.salesianos.dam.clinicflow.entities.extra.DTOs.cita.CreateCitaRequestDTO;
import com.salesianos.dam.clinicflow.services.CitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/citas")
public class CitaController {

    private final CitaService service;

    /* -- CRUD -- */
    @PostMapping()
    public ResponseEntity<CitaResponseDTO> create(CreateCitaRequestDTO createCitaRequestDTO) {
        Cita nuevoCita = service.create(createCitaRequestDTO.from());
        return ResponseEntity.status(201).body(CitaResponseDTO.to(nuevoCita));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitaResponseDTO> read(Long id) {
        Cita cita = service.read(id);
        return ResponseEntity.ok(CitaResponseDTO.to(cita));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CitaResponseDTO> update(Long id, CitaRequestDTO citaRequestDTO) {
        Cita citaActualizado = service.update(id, citaRequestDTO.from());
        return ResponseEntity.ok(CitaResponseDTO.to(citaActualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    /* -- EXTRAS -- */

    @GetMapping
    public ResponseEntity<List<CitaResponseDTO>> getAll() {
        return ResponseEntity.ok(
                service.getAll().stream().map(CitaResponseDTO::to).toList()
        );
    }

    @PutMapping("/citas/{id}/cancelar")
    public ResponseEntity<CitaResponseDTO> cancelarCita(@PathVariable Long id) {
        Cita citaCancelada = service.cancelarCita(id);
        return ResponseEntity.ok(CitaResponseDTO.to(citaCancelada));
    }

}

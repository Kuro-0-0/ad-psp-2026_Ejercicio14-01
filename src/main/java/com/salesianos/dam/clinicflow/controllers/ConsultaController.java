
package com.salesianos.dam.clinicflow.controllers;

import com.salesianos.dam.clinicflow.entities.Consulta;
import com.salesianos.dam.clinicflow.entities.extra.DTOs.consulta.ConsultaRequestDTO;
import com.salesianos.dam.clinicflow.entities.extra.DTOs.consulta.ConsultaResponseDTO;
import com.salesianos.dam.clinicflow.services.ConsultaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/consultas")
public class ConsultaController {

    private final ConsultaService service;

    /* -- CRUD -- */
    @PostMapping()
    public ResponseEntity<ConsultaResponseDTO> create(ConsultaRequestDTO consultaRequestDTO) {
        Consulta nuevoConsulta = service.create(consultaRequestDTO.from());
        return ResponseEntity.status(201).body(ConsultaResponseDTO.to(nuevoConsulta));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaResponseDTO> read(Long id) {
        Consulta consulta = service.read(id);
        return ResponseEntity.ok(ConsultaResponseDTO.to(consulta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultaResponseDTO> update(Long id, ConsultaRequestDTO consultaRequestDTO) {
        Consulta consultaActualizado = service.update(id, consultaRequestDTO.from());
        return ResponseEntity.ok(ConsultaResponseDTO.to(consultaActualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    /* -- EXTRAS -- */

    @GetMapping
    public ResponseEntity<List<ConsultaResponseDTO>> getAll() {
        return ResponseEntity.ok(
                service.getAll().stream().map(ConsultaResponseDTO::to).toList()
        );
    }

}

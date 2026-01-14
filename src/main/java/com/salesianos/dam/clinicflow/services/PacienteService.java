package com.salesianos.dam.clinicflow.services;

import com.salesianos.dam.clinicflow.entities.Paciente;
import com.salesianos.dam.clinicflow.exceptions.notFound.PacienteNotFound;
import com.salesianos.dam.clinicflow.repositories.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository repository;

    /* -- CRUD -- */

    public Paciente create(Paciente p) {
        return repository.save(p);
    }

    public Paciente read(Long id) {
        return repository.findById(id).orElseThrow(() -> new PacienteNotFound(id));
    }

    public Paciente update(Long id, Paciente p) {
        Paciente pOriginal = repository.findById(id).orElseThrow(() -> new PacienteNotFound(id));;
        return repository.save(pOriginal.modify(p));
    }

    public void delete(Long id) {
        Paciente p = repository.findById(id).orElseThrow(() -> new PacienteNotFound(id));
        repository.delete(p);
    }

    /* -- EXTRAS -- */
    public List<Paciente> getAll() {
        return repository.findAll();
    }

}

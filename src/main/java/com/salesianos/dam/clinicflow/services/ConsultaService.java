package com.salesianos.dam.clinicflow.services;

import com.salesianos.dam.clinicflow.entities.Cita;
import com.salesianos.dam.clinicflow.entities.Consulta;
import com.salesianos.dam.clinicflow.exceptions.notFound.ConsultaNotFoundException;
import com.salesianos.dam.clinicflow.repositories.ConsultaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultaService {

    private final ConsultaRepository repository;

    /* -- CRUD -- */

    public Consulta create(Consulta c) {
        return repository.save(c);
    }

    public Consulta read(Long id) {
        return repository.findById(id).orElseThrow(() -> new ConsultaNotFoundException(id));
    }

    public Consulta update(Long id, Consulta c) {
        Consulta cOriginal = repository.findById(id).orElseThrow(() -> new ConsultaNotFoundException(id));;
        return repository.save(cOriginal.modify(c));
    }

    public void delete(Long id) {
        Consulta c = repository.findById(id).orElseThrow(() -> new ConsultaNotFoundException(id));
        repository.delete(c);
    }

    /* -- EXTRAS -- */
    public List<Consulta> getAll() {
        return repository.findAll();
    }
}

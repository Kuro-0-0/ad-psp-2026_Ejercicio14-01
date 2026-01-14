package com.salesianos.dam.clinicflow.services;

import com.salesianos.dam.clinicflow.entities.Cita;
import com.salesianos.dam.clinicflow.exceptions.notFound.CitaNotFoundException;
import com.salesianos.dam.clinicflow.repositories.CitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CitaService {

    private final CitaRepository repository;

    /* -- CRUD -- */

    public Cita create(Cita c) {
        return repository.save(c);
    }

    public Cita read(Long id) {
        return repository.findById(id).orElseThrow(() -> new CitaNotFoundException(id));
    }

    public Cita update(Long id, Cita c) {
        Cita cOriginal = repository.findById(id).orElseThrow(() -> new CitaNotFoundException(id));;
        return repository.save(cOriginal.modify(c));
    }

    public void delete(Long id) {
        Cita c = repository.findById(id).orElseThrow(() -> new CitaNotFoundException(id));
        repository.delete(c);
    }

    /* -- EXTRAS -- */
    public List<Cita> getAll() {
        return repository.findAll();
    }

}

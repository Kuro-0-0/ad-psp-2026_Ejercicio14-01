package com.salesianos.dam.clinicflow.services;

import com.salesianos.dam.clinicflow.entities.Profesional;
import com.salesianos.dam.clinicflow.exceptions.notFound.ProfesionalNotFound;
import com.salesianos.dam.clinicflow.repositories.ProfesionalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfesionalService {

    private final ProfesionalRepository repository;

    /* -- CRUD -- */

    public Profesional create(Profesional p) {
        return repository.save(p);
    }

    public Profesional read(Long id) {
        return repository.findById(id).orElseThrow(() -> new ProfesionalNotFound(id));
    }

    public Profesional update(Long id, Profesional p) {
        Profesional pOriginal = repository.findById(id).orElseThrow(() -> new ProfesionalNotFound(id));;
        return repository.save(pOriginal.modify(p));
    }

    public void delete(Long id) {
        Profesional p = repository.findById(id).orElseThrow(() -> new ProfesionalNotFound(id));
        repository.delete(p);
    }

    /* -- EXTRAS -- */
    public List<Profesional> getAll() {
        return repository.findAll();
    }

}

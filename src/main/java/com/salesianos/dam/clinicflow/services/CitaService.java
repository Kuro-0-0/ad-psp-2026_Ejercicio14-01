package com.salesianos.dam.clinicflow.services;

import com.salesianos.dam.clinicflow.entities.Cita;
import com.salesianos.dam.clinicflow.entities.Consulta;
import com.salesianos.dam.clinicflow.entities.extra.Estado;
import com.salesianos.dam.clinicflow.exceptions.AlreadyCanceledException;
import com.salesianos.dam.clinicflow.exceptions.BadArgumentsException;
import com.salesianos.dam.clinicflow.exceptions.WrongEstadoArgumentException;
import com.salesianos.dam.clinicflow.exceptions.notFound.CitaNotFoundException;
import com.salesianos.dam.clinicflow.repositories.CitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CitaService {

    private final CitaRepository repository;

    /* -- CRUD -- */

    public Cita create(Cita c) {

        List<Cita> citasProfesional = repository.findByProfesionalAndFechaHora(c.getProfesional(), c.getFechaHora());
        List<Cita> citasPaciente = repository.findByPacienteAndFechaHora(c.getPaciente(), c.getFechaHora());

        if (!citasProfesional.isEmpty()) {
            throw new BadArgumentsException("El profesional ya tiene una cita programada a esa hora.");
        }

        if (!citasPaciente.isEmpty()) {
            throw new BadArgumentsException("El paciente ya tiene una cita programada a esa hora.");
        }

        if (c.getFechaHora().isBefore(LocalDateTime.now())) {
            throw new BadArgumentsException("La fecha y hora de la cita no puede ser en el pasado.");
        }

        c.setEstado(Estado.PROGRAMADA);

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
    public Page<Cita> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Cita cancelarCita(Long id) {
        Cita cita = repository.findById(id).orElseThrow(() -> new CitaNotFoundException(id));

        if (cita.getEstado() == Estado.CANCELADA) {
            throw new AlreadyCanceledException();
        }

        return repository.save(cita);
    }

    public Cita registrarConsulta(Long id, Consulta consulta) {
        Cita c = repository.findById(id).orElseThrow(() -> new CitaNotFoundException(id));

        if (c.getEstado() != Estado.PROGRAMADA) {
            throw new WrongEstadoArgumentException("Solo se pueden registrar consultas en citas programadas.");
        }

        c.setConsulta(consulta);
        c.setEstado(Estado.ATENDIDA);
        return repository.save(c);
    };
}

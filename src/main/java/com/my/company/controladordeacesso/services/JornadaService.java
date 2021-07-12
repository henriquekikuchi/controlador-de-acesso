package com.my.company.controladordeacesso.services;

import com.my.company.controladordeacesso.model.JornadaTrabalho;
import com.my.company.controladordeacesso.repository.JornadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JornadaService {

    @Autowired
    JornadaRepository jornadaRepository;

    public JornadaTrabalho save(JornadaTrabalho jornadaTrabalho){
        return jornadaRepository.save(jornadaTrabalho);
    }

    public Optional<JornadaTrabalho> getById(Long id){
        return jornadaRepository.findById(id);
    }

    public void update(JornadaTrabalho jornadaTrabalho){
        jornadaRepository.save(jornadaTrabalho);
    }

    public void delete(Long idJornada){
        jornadaRepository.deleteById(idJornada);
    }

    public List<JornadaTrabalho> getAll() {
        return jornadaRepository.findAll();
    }
}

package com.my.company.controladordeacesso.controller;

import com.my.company.controladordeacesso.model.JornadaTrabalho;
import com.my.company.controladordeacesso.services.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

    @Autowired
    JornadaService jornadaService;

    @PostMapping
    public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.save(jornadaTrabalho);
    }

    @GetMapping("/list")
    public List<JornadaTrabalho> getJornadaList(){
        return jornadaService.getAll();
    }

    @GetMapping("/{idJornada}")
    public ResponseEntity<JornadaTrabalho> getJornadaById(@PathVariable("idJornada") Long id) throws Exception {
        return ResponseEntity.ok(jornadaService.getById(id).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping
    public void updateJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        jornadaService.update(jornadaTrabalho);
    }

    @DeleteMapping("/{idJornada}")
    public ResponseEntity deleteJornada(@PathVariable("idJornada") Long id) {
        try {
            jornadaService.delete(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return (ResponseEntity) ResponseEntity.ok();
    }
}

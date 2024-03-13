package desafio_siad.desafio_siad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import desafio_siad.desafio_siad.model.Fisico;
import desafio_siad.desafio_siad.repository.FisicoRepository;
import lombok.AllArgsConstructor;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/clienteFisico")
@AllArgsConstructor
public class FisicoController {
    @Autowired
    private final FisicoRepository fisicoRepository;

    @GetMapping("/All")
    public @ResponseBody List<Fisico> getALL() {
       return fisicoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fisico> getById(@PathVariable Long id){
        return fisicoRepository.findById(id)
        .map(recordFoumd -> ResponseEntity.ok().body(recordFoumd))
        .orElse(ResponseEntity.notFound().build());
    }

}

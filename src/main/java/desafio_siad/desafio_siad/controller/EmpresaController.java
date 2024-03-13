package desafio_siad.desafio_siad.controller;

import org.springframework.web.bind.annotation.RestController;

import desafio_siad.desafio_siad.model.Empresa;
import desafio_siad.desafio_siad.repository.EmpresRepository;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/empresa")
@AllArgsConstructor

public class EmpresaController {
    @Autowired
    private final EmpresRepository empresRepository;

    @GetMapping("/All")
    public @ResponseBody List<Empresa> getALL() {
       return empresRepository.findAll();
    }

    @GetMapping()
    public @ResponseBody List<Empresa> getAllActiveTrue(){
        return empresRepository.findByActiveTrue();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> getById(@PathVariable Long id){
        return empresRepository.findById(id)
        .map(recordFoumd -> ResponseEntity.ok().body(recordFoumd))
        .orElse(ResponseEntity.notFound().build());
    }
    
    



}

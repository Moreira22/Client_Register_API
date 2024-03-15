package desafio_siad.desafio_siad.controller;


import desafio_siad.desafio_siad.domin.empresa.EmpresaResquestDTO;
import desafio_siad.desafio_siad.model.Empresa;
import desafio_siad.desafio_siad.repository.EmpresRepository;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/empresa")
@AllArgsConstructor

public class EmpresaController {
    @Autowired
    private final EmpresRepository empresRepository;

    @GetMapping("/All")
    public ResponseEntity<List<Empresa>> getALL() {
        var allempresa = empresRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(allempresa);
    }

    @GetMapping()
    public @ResponseBody List<Empresa> getAllActiveTrue(){
        return empresRepository.findByActiveTrue();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> getById(@PathVariable Long id){
        return empresRepository.findById(id)
        .map(recordFoumd -> ResponseEntity.status(HttpStatus.OK).body(recordFoumd))
        .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }
    
    @PostMapping("/register")
    public ResponseEntity<Empresa> posRegisterEmpresa(@RequestBody EmpresaResquestDTO data){
        Empresa newempresa = new Empresa(data);
        empresRepository.save(newempresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(newempresa);
    }
    @PutMapping("/{id}")
    public  ResponseEntity<Empresa> updateEmpresa(@PathVariable Long id, @RequestBody EmpresaResquestDTO data) {
        Optional<Empresa> optionalEmpresa = empresRepository.findById(id);
        if(optionalEmpresa.isPresent()){
            Empresa empresa = optionalEmpresa.get();
            empresa.setNome(data.nome());
            return ResponseEntity.status(HttpStatus.OK).body(empresa);
        }
        return ResponseEntity.noContent().build();
        
    }
    
    
    



}

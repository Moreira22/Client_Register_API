package desafio_siad.desafio_siad.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import desafio_siad.desafio_siad.domin.fisico.FisicoRequestDTO;
import desafio_siad.desafio_siad.model.Fisico;
import desafio_siad.desafio_siad.repository.FisicoRepository;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/clienteFisico")
@AllArgsConstructor
public class FisicoController {
    @Autowired
    private final FisicoRepository fisicoRepository;

    @GetMapping("/All")
    public ResponseEntity<List<Fisico>> getALL() {
        var allfisico = fisicoRepository.findAll();
       return ResponseEntity.status(HttpStatus.OK).body(allfisico);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fisico> getById(@PathVariable Long id){
        return fisicoRepository.findById(id)
        .map(recordFoumd -> ResponseEntity.status(HttpStatus.OK).body(recordFoumd))
        .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @PostMapping("/register")
    public ResponseEntity<Fisico> postRegisterFisico(@RequestBody FisicoRequestDTO data) {
        Fisico newFisico = new Fisico(data);
            fisicoRepository.save(newFisico);
            return ResponseEntity.status(HttpStatus.CREATED).body(newFisico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fisico> updateFisico(@PathVariable Long id, @RequestBody FisicoRequestDTO data) {
        Optional<Fisico> optionalFisico = fisicoRepository.findById(id);
        if(optionalFisico.isPresent()){
            Fisico fisico = optionalFisico.get();
            fisico.setNome(data.nome());
            fisico.setData_nacimento(data.data_nacimento());
            fisico.setCpf(data.cpf());
            fisico.setUf(data.uf());
            fisico.setCidade(data.cidade());
            fisico.setBairro(data.bairro());
            fisico.setNumero(data.numero());
            return ResponseEntity.status(HttpStatus.OK).body(fisico);
        }
        return ResponseEntity.noContent().build();
    }

    

}

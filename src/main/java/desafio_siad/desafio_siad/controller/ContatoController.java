package desafio_siad.desafio_siad.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafio_siad.desafio_siad.model.Cliente;
import desafio_siad.desafio_siad.model.Contato;
import desafio_siad.desafio_siad.model.Fisico;
import desafio_siad.desafio_siad.repository.ContatoRepository;
import desafio_siad.desafio_siad.repository.FisicoRepository;
import lombok.AllArgsConstructor;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/contato")
@AllArgsConstructor
public class ContatoController {
    @Autowired
    private final ContatoRepository contatoRepository;
    
    @GetMapping("/All")
    public @ResponseBody List<Contato> getALL() {
       return contatoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contato> getById(@PathVariable Long id){
        return contatoRepository.findById(id)
        .map(recordFoumd -> ResponseEntity.ok().body(recordFoumd))
        .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping()
    public @ResponseBody List<Contato> getAllActiveTrue(){
        return contatoRepository.findByActiveTrue();
    }

}

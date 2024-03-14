package desafio_siad.desafio_siad.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafio_siad.desafio_siad.domin.contato.ContatoRequestDTO;
import desafio_siad.desafio_siad.model.Contato;
import desafio_siad.desafio_siad.repository.ContatoRepository;
import lombok.AllArgsConstructor;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/contato")
@AllArgsConstructor
public class ContatoController {
    @Autowired
    private final ContatoRepository contatoRepository;
    
    @GetMapping("/All")
    public ResponseEntity <List<Contato>> getALL() {
        var allContato =  contatoRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(allContato);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contato> getById(@PathVariable Long id){
        return contatoRepository.findById(id)
        .map(recordFoumd -> ResponseEntity.status(HttpStatus.OK).body(recordFoumd))
        .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }
    
    @GetMapping()
    public @ResponseBody List<Contato> getAllActiveTrue(){
        return contatoRepository.findByActiveTrue();
    }

    @PostMapping("/register")
    public ResponseEntity<Contato> postregisteConato(@RequestBody ContatoRequestDTO data) {
        Contato newContato = new Contato(data);
        contatoRepository.save(newContato);
        return ResponseEntity.status(HttpStatus.CREATED).body(newContato);
    }
    

}

package desafio_siad.desafio_siad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafio_siad.desafio_siad.domin.juritico.JuriticoRequestDTO;
import desafio_siad.desafio_siad.model.Juridico;
import desafio_siad.desafio_siad.repository.ContatoRepository;
import desafio_siad.desafio_siad.repository.JuriticoResposity;
import lombok.AllArgsConstructor;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/clienteJuritico")
@AllArgsConstructor
public class JuriticoContrller {
    @Autowired
    private final JuriticoResposity juriticoResposity;
    @Autowired
    private final ContatoRepository contatoRepository;

    @GetMapping("/All")
    public ResponseEntity<List<Juridico>> getALL() {
        var alljuritico = juriticoResposity.findAll();
       return ResponseEntity.status(HttpStatus.OK).body(alljuritico);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Juridico> getById(@PathVariable Long id){
        return juriticoResposity.findById(id)
        .map(recordFoumd -> ResponseEntity.status(HttpStatus.OK).body(recordFoumd))
        .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @PostMapping("/register")
    public ResponseEntity<Juridico> postRgisterJuritco(@RequestBody JuriticoRequestDTO data) {
        Juridico newJuridico = new Juridico(data);
        juriticoResposity.save(newJuridico);
        return ResponseEntity.status(HttpStatus.CREATED).body(newJuridico);
    }
    
}

package desafio_siad.desafio_siad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafio_siad.desafio_siad.model.Juridico;
import desafio_siad.desafio_siad.repository.ContatoRepository;
import desafio_siad.desafio_siad.repository.JuriticoResposity;
import lombok.AllArgsConstructor;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/clienteJuritico")
@AllArgsConstructor
public class JuriticoContrller {
    @Autowired
    private final JuriticoResposity juriticoResposity;
    @Autowired
    private final ContatoRepository contatoRepository;

    @GetMapping("/All")
    public @ResponseBody List<Juridico> getALL() {
       return juriticoResposity.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Juridico> getById(@PathVariable Long id){
        return juriticoResposity.findById(id)
        .map(recordFoumd -> ResponseEntity.ok().body(recordFoumd))
        .orElse(ResponseEntity.notFound().build());
    }
}

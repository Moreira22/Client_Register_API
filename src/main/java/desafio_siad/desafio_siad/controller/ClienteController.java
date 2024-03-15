package desafio_siad.desafio_siad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafio_siad.desafio_siad.domin.cliente.ClienteRequestDTO;
import desafio_siad.desafio_siad.model.Cliente;
import desafio_siad.desafio_siad.model.Fisico;
import desafio_siad.desafio_siad.model.Juridico;
import desafio_siad.desafio_siad.repository.ClienteRepository;
import desafio_siad.desafio_siad.repository.FisicoRepository;
import desafio_siad.desafio_siad.repository.JuriticoResposity;
import lombok.AllArgsConstructor;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/cliente")
@AllArgsConstructor
public class ClienteController {
    @Autowired
    private final ClienteRepository clienteRepository;
    @Autowired
    private final FisicoRepository fisicoRepository;
    @Autowired
    private final JuriticoResposity juriticoResposity;

    @GetMapping("/All")
    public ResponseEntity<List<Cliente>> getMethodName(){
       var allClinete = clienteRepository.findAll();
       return ResponseEntity.status(HttpStatus.OK).body(allClinete);
    }

    @GetMapping()
    public @ResponseBody List<Cliente> getAllActiveTrue(){
        return clienteRepository.findByActiveTrue();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable Long id){
        return clienteRepository.findById(id)
        .map(recordFoumd -> ResponseEntity.status(HttpStatus.OK).body(recordFoumd))
        .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @PostMapping("/register")
    public ResponseEntity<Cliente> postRegisterCliente(@RequestBody ClienteRequestDTO data) {
        if(data.cnpf() == null){
            Fisico newFisico = new Fisico(data);
            fisicoRepository.save(newFisico);
            return ResponseEntity.status(HttpStatus.CREATED).body(newFisico);
        }else{
            Juridico newJuridico = new Juridico(data);
            juriticoResposity.save(newJuridico);
            return ResponseEntity.status(HttpStatus.CREATED).body(newJuridico);
        }
    }
    
    
}

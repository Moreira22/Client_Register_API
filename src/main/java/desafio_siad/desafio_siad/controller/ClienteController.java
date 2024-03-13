package desafio_siad.desafio_siad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafio_siad.desafio_siad.model.Cliente;
import desafio_siad.desafio_siad.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
@RequestMapping("/cliente")
@AllArgsConstructor
public class ClienteController {
    @Autowired
    private final ClienteRepository clienteRepository;

    @GetMapping("/All")
    public @ResponseBody List<Cliente> getMethodName(){
        return clienteRepository.findAll();
    }

    @GetMapping()
    public @ResponseBody List<Cliente> getAllActiveTrue(){
        return clienteRepository.findByActiveTrue();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable Long id){
        return clienteRepository.findById(id)
        .map(recordFoumd -> ResponseEntity.ok().body(recordFoumd))
        .orElse(ResponseEntity.notFound().build());
    }
    


}

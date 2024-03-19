package desafio_siad.desafio_siad.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafio_siad.desafio_siad.domin.contato.ContatoRequestDTO;
import desafio_siad.desafio_siad.domin.contato.ContatoResponseDTO;
import desafio_siad.desafio_siad.service.ContatoService;
import jakarta.validation.constraints.NotNull;

import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@Validated
@RestController
@RequestMapping("/contato")

public class ContatoController {
    private final ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }
    
    @GetMapping("/All")
    public @ResponseBody List<ContatoResponseDTO> getALL() {
        return contatoService.list();
    }

    @GetMapping("")
    public @ResponseBody List<ContatoResponseDTO> getALLActive() {
        return contatoService.listActive();
    }

    @GetMapping("/{id}")
    public ContatoResponseDTO getById(@PathVariable Long id){
        return contatoService.findById(id);
    }

    @PostMapping("/register")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ContatoResponseDTO postregisteConato(@RequestBody ContatoRequestDTO data) {
       return contatoService.create(data);
    }

    @PutMapping("/{id}")
    public ContatoResponseDTO updateConato(@PathVariable Long id, @RequestBody @NotNull ContatoRequestDTO data) {
        return contatoService.update(id, data);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteActive(@PathVariable @NotNull Long id){
        contatoService.sofDelete(id);
    }

    

}

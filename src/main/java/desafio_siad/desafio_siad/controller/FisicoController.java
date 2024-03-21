package desafio_siad.desafio_siad.controller;

import org.springframework.http.HttpStatus;

import org.springframework.validation.annotation.Validated;

import desafio_siad.desafio_siad.domin.fisico.FisicoRequestDTO;
import desafio_siad.desafio_siad.domin.fisico.FisicoResponseDTO;
import desafio_siad.desafio_siad.service.FisicoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@Validated
@RestController
@RequestMapping("/clienteFisico")

public class FisicoController {
   
    private final FisicoService fisicoService;

    public FisicoController(FisicoService fisicoService){
        this.fisicoService = fisicoService;
    }


    @GetMapping("/All")
    public @ResponseBody List<FisicoResponseDTO> getALL() {
        return fisicoService.list();
    }

    @GetMapping("")
    public @ResponseBody List<FisicoResponseDTO> getALLActive() {
        return fisicoService.listActive();
    }

    @GetMapping("/{id}")
    public FisicoResponseDTO getById(@PathVariable @NotNull Long id){
       return fisicoService.findById(id);
    }

    @PostMapping("/register")
    @ResponseStatus(code = HttpStatus.CREATED)
    public FisicoResponseDTO postRegisterFisico(@RequestBody FisicoRequestDTO data) {
        return fisicoService.create(data);
    }

    @PutMapping("/{id}")
    public FisicoResponseDTO updateFisico(@PathVariable Long id, @RequestBody @Valid @NotNull FisicoRequestDTO data) {
       return fisicoService.update(id, data);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void  deleteActive(@PathVariable @NotNull Long id){
        fisicoService.sofDelete(id);
    }

    

}

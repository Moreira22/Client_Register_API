package desafio_siad.desafio_siad.controller;


import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;

import desafio_siad.desafio_siad.domin.juritico.JuriticoRequestDTO;
import desafio_siad.desafio_siad.domin.juritico.JuriticoResponseDTO;
import desafio_siad.desafio_siad.service.JuriticoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

import java.util.List;




import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@Validated
@RestController
@RequestMapping("/clienteJuritico")

public class JuriticoContrller {
   private final JuriticoService juriticoService;

   public JuriticoContrller(JuriticoService juriticoService){
    this.juriticoService = juriticoService;
   }
  

    @GetMapping("/All")
    public @ResponseBody List<JuriticoResponseDTO> getALL() {
       return juriticoService.list();
    }

    @GetMapping("")
    public @ResponseBody List<JuriticoResponseDTO> getALLActive() {
       return juriticoService.listActive();
    }

    @GetMapping("/contatotrue/{active}")
    public @ResponseBody List<JuriticoResponseDTO> getConatoTrue(@PathVariable boolean active) {
       return juriticoService.findAllByContatos_Ativo(active);
    }
    
    
    @GetMapping("/{id}")
    public JuriticoResponseDTO getById(@PathVariable Long id){
       return juriticoService.findById(id);
    }

    @PostMapping("/register")
    @ResponseStatus(code = HttpStatus.CREATED)
    public JuriticoResponseDTO postRgisterJuritco(@RequestBody JuriticoRequestDTO data) {
        return juriticoService.create(data);
    }

    @PutMapping("/{id}")
    public JuriticoResponseDTO updateJuritico(@PathVariable long id, @RequestBody @Valid @NotNull JuriticoRequestDTO data) {
        return juriticoService.update(id, data);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteActive(@PathVariable @NotNull Long id){
        juriticoService.sofDelete(id);
    }

    
}

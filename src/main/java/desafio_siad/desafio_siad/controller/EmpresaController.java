package desafio_siad.desafio_siad.controller;


import desafio_siad.desafio_siad.domin.empresa.EmpresaResponseDTO;
import desafio_siad.desafio_siad.domin.empresa.EmpresaResquestDTO;
import desafio_siad.desafio_siad.service.EmpresaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/empresa")
public class EmpresaController {
  
    private final EmpresaService empresService;

    public EmpresaController(EmpresaService empresaService){
      this.empresService = empresaService;
    }

    @GetMapping("/All")
    public @ResponseBody List<EmpresaResponseDTO> getALL() {
        return empresService.list();
        
    }

    @GetMapping("")
    public @ResponseBody List<EmpresaResponseDTO> getALLActive() {
        return empresService.listActive();
    }
    
    @GetMapping("/{id}")
    public EmpresaResponseDTO getById(@PathVariable @NotNull Long id){
       return empresService.findById(id);
    }
    
    @PostMapping("/register")
    @ResponseStatus(code = HttpStatus.CREATED)
    public EmpresaResponseDTO posRegisterEmpresa(@RequestBody @Valid EmpresaResquestDTO data){
        return empresService.create(data);
    }
    @PutMapping("/{id}")
    public EmpresaResponseDTO  updateEmpresa(@PathVariable Long id, @RequestBody @Valid @NotNull EmpresaResquestDTO data) {
       return empresService.update(id, data);
        
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteActive(@PathVariable @NotNull Long id){
        empresService.sofDelete(id);
    }

}

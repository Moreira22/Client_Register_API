package desafio_siad.desafio_siad.domin.empresa;


import desafio_siad.desafio_siad.model.Cliente;

public record EmpresaResponseDTO(Long id,
    Boolean active,
    String nome) {
        
}

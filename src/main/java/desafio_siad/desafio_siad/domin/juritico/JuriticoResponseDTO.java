package desafio_siad.desafio_siad.domin.juritico;


import java.util.List;
import desafio_siad.desafio_siad.domin.contato.ContatoRequestDTO;
import desafio_siad.desafio_siad.model.Empresa;


public record JuriticoResponseDTO(Long id,
        String nome,
        Boolean active,
        String data_nacimento,
        String cnpf,
        String ie,
        Empresa empresa) {
    
}

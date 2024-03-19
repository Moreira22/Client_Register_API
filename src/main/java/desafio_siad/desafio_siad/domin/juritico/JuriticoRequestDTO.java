package desafio_siad.desafio_siad.domin.juritico;


import desafio_siad.desafio_siad.domin.contato.ContatoRequestDTO;
import desafio_siad.desafio_siad.model.Empresa;
import java.util.List;

public record JuriticoRequestDTO(
        Long id,
        String nome,
        Boolean active,
        String data_nacimento,
        String cnpf,
        String ie,
        List<ContatoRequestDTO> contato,
        Empresa empresa) {
}

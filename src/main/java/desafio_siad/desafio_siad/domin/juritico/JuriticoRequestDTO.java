package desafio_siad.desafio_siad.domin.juritico;
import java.util.List;

import desafio_siad.desafio_siad.domin.contato.ContatoRequestDTO;

public record JuriticoRequestDTO(
        Long id,
        String nome,
        String data_nacimento,
        String cnpf,
        String ie,
        List<ContatoRequestDTO> contato) {
}

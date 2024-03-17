package desafio_siad.desafio_siad.domin.contato;

import desafio_siad.desafio_siad.model.Juridico;

public record ContatoRequestDTO(
    Long id,
    String descicao,
    Integer numero,
    Boolean active,
    Juridico juridico) {

}

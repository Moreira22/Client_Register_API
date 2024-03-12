package desafio_siad.desafio_siad.domin.cliente;

import desafio_siad.desafio_siad.model.Empresa;

public record ClienteRequestDTO(
    Long id,
    String nomoe,
    String data_nacimento,
    Empresa empresa
) {

}

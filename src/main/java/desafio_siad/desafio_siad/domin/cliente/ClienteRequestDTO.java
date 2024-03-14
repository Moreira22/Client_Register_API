package desafio_siad.desafio_siad.domin.cliente;

import desafio_siad.desafio_siad.model.Empresa;

public record ClienteRequestDTO(
    Long id,
    String nome,
    Boolean active,
    String data_nacimento,
    String cpf,
    String uf,
    String cidade,
    String bairro,
    Integer numero,
    String cnpf,
    String ie,
    Empresa empresa
) {

}

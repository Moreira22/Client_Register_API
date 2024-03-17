package desafio_siad.desafio_siad.domin.fisico;

import desafio_siad.desafio_siad.model.Empresa;


public record FisicoResponseDTO(Long id,
    String nome,
    Boolean active,
    String data_nacimento,
    String cpf,
    String uf,
    String cidade,
    String bairro,
    Integer numero,
    Empresa empresa) {
    
}

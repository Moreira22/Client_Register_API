package desafio_siad.desafio_siad.domin.fisico;

import desafio_siad.desafio_siad.model.Fisico;

public record FisicoResponseDTO(Long id, String nome, String data_nacimento, String cpf, String cidade, String bairro, Integer numero) {
    public FisicoResponseDTO(Fisico fisico){
        this(fisico.getId(), fisico.getNome(), fisico.getData_nacimento(), fisico.getCpf(), fisico.getCidade(), fisico.getBairro(), fisico.getNumero());
    }
}

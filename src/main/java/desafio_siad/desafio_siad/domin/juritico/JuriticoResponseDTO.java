package desafio_siad.desafio_siad.domin.juritico;

import desafio_siad.desafio_siad.model.Juridico;

public record JuriticoResponseDTO(Long id, String nome, String data_nacimento, String cnpf, String ie) {
    public JuriticoResponseDTO(Juridico juridico){
        this(juridico.getId(), juridico.getNome(), juridico.getData_nacimento(), juridico.getCnpf(), juridico.getIe());
    }
}

package desafio_siad.desafio_siad.domin.contato;

import desafio_siad.desafio_siad.model.Contato;
import desafio_siad.desafio_siad.model.Juridico;

public record ContatoResponseDTO(Long id, String descicao, Integer numero, Juridico juridico) {
    public ContatoResponseDTO(Contato contato){
        this(contato.getId(), contato.getDescicao(), contato.getNumero(), contato.getJuridico());
    }
}

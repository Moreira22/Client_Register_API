package desafio_siad.desafio_siad.domin.contato;

import org.springframework.stereotype.Component;

import desafio_siad.desafio_siad.model.Contato;

@Component
public class ContatoMapper {
    public ContatoResponseDTO toDTO(Contato contato){
        return new ContatoResponseDTO(contato.getId(), contato.getDescicao(),contato.getNumero(),contato.getActive(),contato.getJuridico());
    }
    public Contato toEntity(ContatoRequestDTO requestDTO){
        if(requestDTO == null){
            return null;
        }
        Contato contato = new Contato();
        if(requestDTO.id() != null){
            contato.setId(requestDTO.id());
        }
        contato.setDescicao(requestDTO.descicao());
        contato.setNumero(requestDTO.numero());
        contato.setJuridico(requestDTO.juridico());

        return contato;
    }
}

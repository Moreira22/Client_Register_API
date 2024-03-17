package desafio_siad.desafio_siad.domin.fisico;

import org.springframework.stereotype.Component;

import desafio_siad.desafio_siad.model.Fisico;

@Component
public class FisicoMapper {
    public FisicoResponseDTO toDTO(Fisico fisico){
        return new FisicoResponseDTO(fisico.getId(), fisico.getNome(), fisico.getActive(), fisico.getData_nacimento(), fisico.getCpf(), 
        fisico.getUf(), fisico.getCidade(), fisico.getBairro(), fisico.getNumero(), fisico.getEmpresa());
    }
    public Fisico toEntity(FisicoRequestDTO fisicoRequestDTO){
        if(fisicoRequestDTO ==null){
            return null;
        }
        Fisico fisico = new Fisico();

        if(fisicoRequestDTO.id() != null){
            fisico.setId(fisicoRequestDTO.id());
        }
        fisico.setNome(fisicoRequestDTO.nome());
        fisico.setActive(fisicoRequestDTO.active());
        fisico.setData_nacimento(fisicoRequestDTO.data_nacimento());
        fisico.setCpf(fisicoRequestDTO.cpf());
        fisico.setUf(fisicoRequestDTO.uf());
        fisico.setBairro(fisicoRequestDTO.bairro());
        fisico.setNumero(fisicoRequestDTO.numero());
        fisico.setEmpresa(fisicoRequestDTO.empresa());
        return fisico;
    }

}

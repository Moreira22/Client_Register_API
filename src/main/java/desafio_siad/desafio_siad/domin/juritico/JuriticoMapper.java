package desafio_siad.desafio_siad.domin.juritico;

import org.springframework.stereotype.Component;


import desafio_siad.desafio_siad.model.Juridico;

@Component
public class JuriticoMapper {
    public JuriticoResponseDTO toDTO( Juridico juridico){
        return new JuriticoResponseDTO(juridico.getId(), juridico.getNome(), juridico.getActive(), juridico.getData_nacimento(), 
        juridico.getCnpf(), juridico.getIe());
    }
    public Juridico toEntity(JuriticoRequestDTO requestDTO){
        if(requestDTO == null){
            return null;
        }
        Juridico juridico = new Juridico();
        if(requestDTO.id() != null){
            juridico.setId(requestDTO.id());
        }
        juridico.setNome(requestDTO.nome());
        juridico.setActive(requestDTO.active());
        juridico.setData_nacimento(requestDTO.data_nacimento());
        juridico.setCnpf(requestDTO.cnpf());
        juridico.setIe(requestDTO.ie());
        juridico.setEmpresa(requestDTO.empresa());

        return juridico;

    }

}

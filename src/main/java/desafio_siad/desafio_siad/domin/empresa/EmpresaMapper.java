package desafio_siad.desafio_siad.domin.empresa;

import org.springframework.stereotype.Component;

import desafio_siad.desafio_siad.model.Empresa;



@Component
public class EmpresaMapper {
    public EmpresaResponseDTO toDTO( Empresa empresa ){
        return new EmpresaResponseDTO(empresa.getId(), empresa.getActive(), empresa.getNome() );
    }
    public Empresa toEntity(EmpresaResquestDTO resquestDTO){
        if(resquestDTO == null){
            return null;
        }
        Empresa empresa = new Empresa();
        if(resquestDTO.id() != null){
            empresa.setId(resquestDTO.id());
        }
        empresa.setNome(resquestDTO.nome());
        empresa.setActive(resquestDTO.active());
        
        return empresa;
    }

}

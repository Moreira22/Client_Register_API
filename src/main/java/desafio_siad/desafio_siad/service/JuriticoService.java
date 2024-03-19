package desafio_siad.desafio_siad.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import desafio_siad.desafio_siad.domin.juritico.JuriticoMapper;
import desafio_siad.desafio_siad.domin.juritico.JuriticoRequestDTO;
import desafio_siad.desafio_siad.domin.juritico.JuriticoResponseDTO;
import desafio_siad.desafio_siad.exception.RecordNotFoundException;
import desafio_siad.desafio_siad.repository.JuriticoResposity;
import jakarta.validation.Valid;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;

@Validated
@Service
public class JuriticoService {
    private final JuriticoResposity juriticoResposity;
    private final JuriticoMapper juriticoMapper;

    public JuriticoService( JuriticoResposity juriticoResposity,JuriticoMapper juriticoMapper ){
        this.juriticoResposity = juriticoResposity;
        this.juriticoMapper = juriticoMapper;
    }

    public List<JuriticoResponseDTO> list(){
        return juriticoResposity.findAll()
            .stream()
            .map(juriticoMapper::toDTO)
            .collect(Collectors.toList());
    }

    public List<JuriticoResponseDTO> listActive(){
        return juriticoResposity.findByActiveTrue()
            .stream()
            .map(juriticoMapper::toDTO)
            .collect(Collectors.toList());
    }

    public JuriticoResponseDTO findById(@NotNull Long id){
        return juriticoResposity.findById(id).map(juriticoMapper::toDTO)
               .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public List<JuriticoResponseDTO> findAllByContatos_Ativo(@NotNull boolean active){
        return juriticoResposity.findAllByContatos_Active(active).stream()
        .map(juriticoMapper::toDTO)
        .collect(Collectors.toList());
    }

    public JuriticoResponseDTO create(@Valid @NotNull JuriticoRequestDTO juritico){
        return juriticoMapper.toDTO(juriticoResposity.save(juriticoMapper.toEntity(juritico)));
    }

    public JuriticoResponseDTO update(@NotNull Long id, @Valid @NotNull JuriticoRequestDTO juritico){
        return juriticoResposity.findById(id).map(recordFound ->{
            recordFound.setNome(juritico.nome());
            recordFound.setData_nacimento(juritico.data_nacimento());
            recordFound.setCnpf(juritico.cnpf());
            recordFound.setIe(juritico.ie());  
            recordFound.setEmpresa(juritico.empresa());
            juriticoResposity.save(recordFound);
            return juriticoMapper.toDTO(recordFound);        
        }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@NotNull Long id){
        juriticoResposity.delete(juriticoResposity.findById(id).orElseThrow(() -> new RecordNotFoundException(id)));
    }

    @Transactional
    public void sofDelete(@NotNull Long id){
        juriticoResposity.findById(id).map(recordFound ->{
            recordFound.setActive(false);
            return recordFound;
        }).orElseThrow(() -> new RecordNotFoundException(id));
    }
}

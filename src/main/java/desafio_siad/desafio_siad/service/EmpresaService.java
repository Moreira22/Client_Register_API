package desafio_siad.desafio_siad.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import desafio_siad.desafio_siad.domin.empresa.EmpresaMapper;
import desafio_siad.desafio_siad.domin.empresa.EmpresaResponseDTO;
import desafio_siad.desafio_siad.domin.empresa.EmpresaResquestDTO;
import desafio_siad.desafio_siad.exception.RecordNotFoundException;
import desafio_siad.desafio_siad.repository.EmpresRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Validated
@Service
public class EmpresaService {
    private final EmpresRepository empresRepository;
    private final EmpresaMapper empresaMapper;

    public EmpresaService(EmpresRepository empresRepository, EmpresaMapper empresaMapper){
        this.empresRepository = empresRepository;
        this.empresaMapper = empresaMapper;
    }

    public List<EmpresaResponseDTO> list(){
        return empresRepository.findAll()
            .stream()
            .map(empresaMapper::toDTO)
            .collect(Collectors.toList());
    }
    public List<EmpresaResponseDTO> listActive(){
        return empresRepository.findByActiveTrue()
             .stream()
             .map(empresaMapper::toDTO)
             .collect(Collectors.toList());
    }

    public EmpresaResponseDTO findById(@NotNull Long id){
        return empresRepository.findById(id).map(empresaMapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public EmpresaResponseDTO create(@Valid @NotNull EmpresaResquestDTO empresa ){
        return empresaMapper.toDTO(empresRepository.save(empresaMapper.toEntity(empresa)));
    }

    public EmpresaResponseDTO update(@NotNull Long id, @Valid @NotNull EmpresaResquestDTO empresa){
        return empresRepository.findById(id).map(recordFound ->{
            recordFound.setNome(empresa.nome());
            empresRepository.save(recordFound);
            return empresaMapper.toDTO(recordFound);
        })
        .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@NotNull Long id){
        empresRepository.delete(empresRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id)));
    }

    @Transactional
    public void sofDelete(@NotNull Long id){
        empresRepository.findById(id).map(recordFound -> {
            recordFound.setActive(false);
            return recordFound;
        }).orElseThrow(() -> new RecordNotFoundException(id));
    }

}

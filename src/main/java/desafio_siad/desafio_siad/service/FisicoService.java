package desafio_siad.desafio_siad.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import desafio_siad.desafio_siad.domin.fisico.FisicoMapper;
import desafio_siad.desafio_siad.domin.fisico.FisicoRequestDTO;
import desafio_siad.desafio_siad.domin.fisico.FisicoResponseDTO;
import desafio_siad.desafio_siad.exception.RecordNotFoundException;
import desafio_siad.desafio_siad.repository.FisicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Validated
@Service
public class FisicoService {
    private final FisicoRepository fisicoRepository;
    private final FisicoMapper fisicoMapper;

    public FisicoService(FisicoRepository fisicoRepository, FisicoMapper fisicoMapper){
        this.fisicoRepository = fisicoRepository;
        this.fisicoMapper = fisicoMapper;
    }

    public List<FisicoResponseDTO> list(){
        return fisicoRepository.findAll()
              .stream()
              .map(fisicoMapper::toDTO)
              .collect(Collectors.toList());
    }
    public FisicoResponseDTO findById(@NotNull Long id){
        return fisicoRepository.findById(id).map(fisicoMapper::toDTO)
               .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public FisicoResponseDTO create(@Valid @NotNull FisicoRequestDTO fisico){
        return fisicoMapper.toDTO(fisicoRepository.save(fisicoMapper.toEntity(fisico)));
    }

    public FisicoResponseDTO update(@NotNull Long id,@Valid @NotNull FisicoRequestDTO fisico){
        return fisicoRepository.findById(id).map(recordFound ->{
            recordFound.setNome(fisico.nome());
            recordFound.setActive(fisico.active());
            recordFound.setData_nacimento(fisico.data_nacimento());
            recordFound.setCpf(fisico.cpf());
            recordFound.setUf(fisico.uf());
            recordFound.setCidade(fisico.cidade());
            recordFound.setBairro(fisico.bairro());
            recordFound.setNumero(fisico.numero());
            return fisicoMapper.toDTO(recordFound);
        }).orElseThrow(() -> new RecordNotFoundException(id));
    } 

    public void delete(@NotNull Long id){
        fisicoRepository.delete(fisicoRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id)));
    }

    @Transactional
    public void sofDelete(@NotNull Long id){
        fisicoRepository.findById(id).map(recordFound ->{
            recordFound.setActive(false);
            return recordFound;
        }).orElseThrow(() -> new RecordNotFoundException(id));
    }


}

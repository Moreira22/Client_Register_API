package desafio_siad.desafio_siad.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import desafio_siad.desafio_siad.domin.contato.ContatoMapper;
import desafio_siad.desafio_siad.domin.contato.ContatoRequestDTO;
import desafio_siad.desafio_siad.domin.contato.ContatoResponseDTO;
import desafio_siad.desafio_siad.exception.RecordNotFoundException;
import desafio_siad.desafio_siad.repository.ContatoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Validated
@Service
public class ContatoService {
    private final ContatoRepository contatoRepository;
    private final ContatoMapper contatoMapper;

    public ContatoService(ContatoRepository contatoRepository, ContatoMapper contatoMappe){
        this.contatoRepository = contatoRepository;
        this.contatoMapper = contatoMappe;
    }

    public List<ContatoResponseDTO> lsit(){
        return contatoRepository.findAll()
              .stream()
              .map(contatoMapper::toDTO)
              .collect(Collectors.toList());
    }
    
    public ContatoResponseDTO findById(@NotNull Long id){
        return contatoRepository.findById(id).map(contatoMapper::toDTO)
               .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public ContatoResponseDTO create(@Valid @NotNull ContatoRequestDTO contato){
        return contatoMapper.toDTO(contatoRepository.save(contatoMapper.toEntity(contato)));
    }

    public ContatoResponseDTO update(@NotNull Long id, @Valid @NotNull ContatoRequestDTO contato ){
        return contatoRepository.findById(id).map(recordFound -> {
            recordFound.setDescicao(contato.descicao());
            recordFound.setNumero(contato.numero());
            return contatoMapper.toDTO(recordFound);
        })
        .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@NotNull Long id){
        contatoRepository.delete(contatoRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id)));
    }

    @Transactional
    public void sofDelete(@NotNull Long id){
        contatoRepository.findById(id).map(recordFound -> {
            recordFound.setActive(false);
            return recordFound;
        }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    

}

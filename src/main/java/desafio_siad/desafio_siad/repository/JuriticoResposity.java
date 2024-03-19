package desafio_siad.desafio_siad.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import desafio_siad.desafio_siad.model.Juridico;

@Repository
public interface JuriticoResposity extends JpaRepository<Juridico, Long>{
    List<Juridico> findByActiveTrue();
    List<Juridico> findAllByContatos_Active(boolean active);
}

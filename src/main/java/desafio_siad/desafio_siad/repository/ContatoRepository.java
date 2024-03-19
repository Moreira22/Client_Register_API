package desafio_siad.desafio_siad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import desafio_siad.desafio_siad.model.Contato;


@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long>{
     List<Contato> findByActiveTrue();
     // List<Contato> findALlByJuritico_id(long id);
}

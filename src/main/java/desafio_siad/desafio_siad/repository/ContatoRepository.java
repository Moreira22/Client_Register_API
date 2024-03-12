package desafio_siad.desafio_siad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import desafio_siad.desafio_siad.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long>{

}

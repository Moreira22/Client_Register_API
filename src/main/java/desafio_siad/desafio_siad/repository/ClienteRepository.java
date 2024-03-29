package desafio_siad.desafio_siad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import desafio_siad.desafio_siad.model.Cliente;
import java.util.List;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByActiveTrue();
}

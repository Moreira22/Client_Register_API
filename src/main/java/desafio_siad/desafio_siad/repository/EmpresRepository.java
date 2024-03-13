package desafio_siad.desafio_siad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import desafio_siad.desafio_siad.model.Empresa;
import java.util.List;


@Repository
public interface EmpresRepository extends JpaRepository<Empresa , Long> {
    List<Empresa> findByActiveTrue();
}

package desafio_siad.desafio_siad.domin.empresa;
import java.util.List;

import desafio_siad.desafio_siad.domin.cliente.ClienteRequestDTO;
public record EmpresaResquestDTO(
    Long id,
    String nome,
    Boolean active,
    List<ClienteRequestDTO> cliente) {

}

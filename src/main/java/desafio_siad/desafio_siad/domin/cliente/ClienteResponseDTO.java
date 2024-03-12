package desafio_siad.desafio_siad.domin.cliente;

import desafio_siad.desafio_siad.model.Cliente;
import desafio_siad.desafio_siad.model.Empresa;

public record ClienteResponseDTO(Long id, String nomo, String data_nacimento,  Empresa empresa) {
    public ClienteResponseDTO(Cliente cliente){
        this(cliente.getId(), cliente.getNome(), cliente.getData_nacimento(), cliente.getEmpresa());
    }

}

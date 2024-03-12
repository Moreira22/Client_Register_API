package desafio_siad.desafio_siad.domin.empresa;

import desafio_siad.desafio_siad.model.Empresa;

public record EmpresaResponseDTO(long id, String nome) {
        public EmpresaResponseDTO( Empresa empresa){
            this(empresa.getId(), empresa.getNome());
        }
}

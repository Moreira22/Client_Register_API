package desafio_siad.desafio_siad.domin.juritico;


public record JuriticoResponseDTO(Long id,
        String nome,
        Boolean active,
        String data_nacimento,
        String cnpf,
        String ie) {
    
}

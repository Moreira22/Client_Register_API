package desafio_siad.desafio_siad.domin.fisico;

public record FisicoRequestDTO(
    Long id,
    String nome,
    String data_nacimento,
    String cpf,
    String uf,
    String cidade,
    String bairro,
    Integer numero){

}

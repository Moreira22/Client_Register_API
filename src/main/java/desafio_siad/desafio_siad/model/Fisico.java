package desafio_siad.desafio_siad.model;

import desafio_siad.desafio_siad.domin.fisico.FisicoRequestDTO;
import desafio_siad.desafio_siad.domin.fisico.FisicoResponseDTO;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("fisico")
public class Fisico extends Cliente {

    @Column
    private String cpf;

    @Column
    private String uf;

    @Column
    private String cidade;

    @Column
    private String bairro;

    @Column
    private Integer numero;

     public Fisico(FisicoRequestDTO data){
      this.cpf = data.cpf();
      this.uf = data.uf();
      this.cidade = data.cidade();
      this.bairro = data.bairro();
      this.numero = data.numero();
    }
}

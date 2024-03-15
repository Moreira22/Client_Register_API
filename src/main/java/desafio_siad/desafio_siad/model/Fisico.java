package desafio_siad.desafio_siad.model;

import desafio_siad.desafio_siad.domin.cliente.ClienteRequestDTO;
import desafio_siad.desafio_siad.domin.fisico.FisicoRequestDTO;
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


    public Fisico(ClienteRequestDTO data) {
      super(data.nome(), data.data_nacimento(), data.active(), data.empresa());
      this.cpf = data.cpf();
      this.uf = data.uf();
      this.cidade = data.cidade();
      this.bairro = data.bairro();
      this.numero = data.numero();
    }
    
    public Fisico(FisicoRequestDTO data) {
      super(data.nome(), data.data_nacimento(), data.active(), data.empresa());
      this.cpf = data.cpf();
      this.uf = data.uf();
      this.cidade = data.cidade();
      this.bairro = data.bairro();
      this.numero = data.numero();
    }
    
}

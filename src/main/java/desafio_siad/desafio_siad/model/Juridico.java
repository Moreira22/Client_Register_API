package desafio_siad.desafio_siad.model;

import java.util.ArrayList;
import java.util.List;

import desafio_siad.desafio_siad.domin.cliente.ClienteRequestDTO;
import desafio_siad.desafio_siad.domin.juritico.JuriticoRequestDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("juridico")
public class Juridico  extends Cliente{
    @Column
    private String cnpf;

    @Column
    private String ie;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "juridico")
    private List<Contato> contatos = new ArrayList<>();

    public Juridico(ClienteRequestDTO data) {
      super(data.nome(), data.data_nacimento(), data.active(), data.empresa());
      this.cnpf = data.cnpf();
      this.ie = data.ie();
    }

    public Juridico(JuriticoRequestDTO data){
      super(data.nome(), data.data_nacimento(), data.active(), data.empresa());
      this.cnpf = data.cnpf();
      this.ie = data.ie();
    }
}

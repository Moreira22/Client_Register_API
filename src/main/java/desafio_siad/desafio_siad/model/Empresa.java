package desafio_siad.desafio_siad.model;

import jakarta.persistence.Entity;

import java.util.ArrayList;
import java.util.List;

import desafio_siad.desafio_siad.domin.empresa.EmpresaResquestDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Empresa {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    @Column( length = 200, nullable = false, name = "nome")
    private String nome;

    @Column
    private Boolean active;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "empresa")
    private List<Cliente> cliente = new ArrayList<>();

    public Empresa(EmpresaResquestDTO data){
        this.nome = data.nome();
        this.active = true;
    }
}

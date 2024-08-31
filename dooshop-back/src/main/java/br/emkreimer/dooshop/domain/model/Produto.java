package br.emkreimer.dooshop.domain.model;

import br.emkreimer.dooshop.domain.enums.Categoria;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name="produto", schema="public")
public class Produto {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_PRODUTO")
    @SequenceGenerator(name="SEQ_PRODUTO", sequenceName="id_seq_produto", allocationSize=1)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    private BigDecimal valor;
    
    private Categoria categoria;

    private Integer estoque = 0;

    @ManyToMany(mappedBy="produtos", fetch=FetchType.LAZY)
    @JsonIgnore
    private List<Empresa> fornecedores;

}

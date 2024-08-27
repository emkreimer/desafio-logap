package br.emkreimer.dooshop.domain.model;

import br.emkreimer.dooshop.domain.enums.Categoria;
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
    @Column(name="id")
    private Integer id;

    @Column(name="nome", nullable = false)
    private String nome;

    @Column(name="preco")
    private BigDecimal valor;

    private Categoria categoria;

    @Column(name="estoque")
    private Integer estoque = 0;

    @ManyToMany(mappedBy="produtos")
    private List<Empresa> fornecedores;


}

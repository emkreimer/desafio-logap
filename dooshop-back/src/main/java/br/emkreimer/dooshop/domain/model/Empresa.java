package br.emkreimer.dooshop.domain.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="empresa", schema="public")
public class Empresa {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_EMPRESA")
    @SequenceGenerator(name="SEQ_EMPRESA", sequenceName="id_seq_empresa", allocationSize=1)
    private Integer id;

    @Column(unique=true, nullable=false)
    private String nome;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="empresas_produtos", schema="public", joinColumns=@JoinColumn(name="id_empresa"), inverseJoinColumns = @JoinColumn(name="id_produto"))
    @JsonManagedReference
    private List<Produto> produtos = new ArrayList<>();
}

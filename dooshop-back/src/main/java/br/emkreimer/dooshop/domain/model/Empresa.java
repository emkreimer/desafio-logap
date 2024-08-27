package br.emkreimer.dooshop.domain.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="empresa", schema="public")
public class Empresa {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;

    @Column(name="nome", nullable = false)
    private String nome;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="empresas_produtos", schema="public", joinColumns=@JoinColumn(name="id_empresa"), inverseJoinColumns = @JoinColumn(name="id_produto"))
    private List<Empresa> fornecedores = new ArrayList<>();
}

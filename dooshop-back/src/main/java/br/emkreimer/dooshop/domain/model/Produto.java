package br.emkreimer.dooshop.domain.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="produto", schema="public")
public class Produto {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;

    @Column(name="nome", nullable = false)
    private String nome;



}

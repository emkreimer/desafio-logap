package br.emkreimer.dooshop.domain.enums;

import lombok.Getter;

@Getter
public enum Categoria {

    FRUTAS(1, "fruta"),
    CEREAIS(2, "cereais"),
    LEGUMES(3, "legume");

    private final int id;
    private final String categoria;

    Categoria(int id, String categoria) {
        this.id = id;
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }
}

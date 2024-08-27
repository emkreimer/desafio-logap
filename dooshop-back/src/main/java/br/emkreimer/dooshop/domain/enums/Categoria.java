package br.emkreimer.dooshop.domain.enums;

public enum Categoria {

    FRUTAS("fruta"),
    CEREAIS("cereais"),
    LEGUMES("legume");

    private String categoria;

    Categoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }
}

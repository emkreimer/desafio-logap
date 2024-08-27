package br.emkreimer.dooshop.domain.model;

import lombok.Data;

@Data
public class CharResponse {

    public CharResponse(String string, Character vogal, long tempoTotal) {}

    public String string;
    public Character vogal;
    public long tempoTotal;

}

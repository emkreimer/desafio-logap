package br.emkreimer.dooshop.model;

import lombok.Data;

@Data
public class CharResponse {

    public CharResponse(String string, Character vogal, long tempoTotal) {}

    public String string;
    public Character vogal;
    public long tempoTotal;

}

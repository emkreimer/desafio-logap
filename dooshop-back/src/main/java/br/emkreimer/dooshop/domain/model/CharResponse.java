package br.emkreimer.dooshop.domain.model;

import lombok.Data;

import java.time.Instant;

@Data
public class CharResponse {

    public CharResponse() {}

    public String string;
    public Character vogal;
    public long tempoTotal;

}

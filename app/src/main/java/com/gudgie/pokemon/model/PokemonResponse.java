package com.gudgie.pokemon.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PokemonResponse {

    private int count;

    private String previous;

    @SerializedName("results")
    private List<NamedApiResource> pokemon;

    public int getCount() {
        return count;
    }

    public String getPrevious() {
        return previous;
    }

    public List<NamedApiResource> getPokemon() {
        return pokemon;
    }

}

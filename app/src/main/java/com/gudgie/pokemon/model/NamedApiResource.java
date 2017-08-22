package com.gudgie.pokemon.model;

import com.gudgie.pokemon.view.PokemonListItemView;

public abstract class NamedApiResource implements PokemonListItemView.ViewModel {

    private String name;

    private String url;

    public String getName() {
        return name;
    }

    @Override
    public String getUrl() {
        return url;
    }

}
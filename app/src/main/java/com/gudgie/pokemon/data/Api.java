package com.gudgie.pokemon.data;

import com.gudgie.pokemon.model.PokemonResponse;

import javax.inject.Inject;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

    private final PokeApiService service;

    @Inject
    public Api() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(PokeApiService.class);
    }

    public void getPokemon(Callback<PokemonResponse> callback) {
        service.listPokemon().enqueue(callback);
    }

}

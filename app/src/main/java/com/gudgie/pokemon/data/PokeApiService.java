package com.gudgie.pokemon.data;

import com.gudgie.pokemon.model.PokemonResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokeApiService {

    @GET("pokemon")
    Call<PokemonResponse> listPokemon();

}

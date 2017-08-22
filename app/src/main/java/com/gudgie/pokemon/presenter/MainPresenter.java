package com.gudgie.pokemon.presenter;

import com.gudgie.pokemon.data.Api;
import com.gudgie.pokemon.model.PokemonNamedApiResource;
import com.gudgie.pokemon.model.PokemonResponse;
import com.gudgie.pokemon.view.BaseView;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class MainPresenter extends BasePresenter<MainPresenter.View> {

    @Inject Api api;

    @Inject
    MainPresenter() {}

    @Override
    public void onViewCreated(View view) {
        super.onViewCreated(view);
        loadPokemon();
    }

    private void loadPokemon() {
        api.getPokemon(new Callback<PokemonResponse>() {
            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
                getView().setPokemonResources(response.body().getPokemon());
            }

            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {
                Timber.e(t);
            }
        });
    }

    public interface View extends BaseView {

        void setPokemonResources(List<PokemonNamedApiResource> pokemon);

    }

}

package com.gudgie.pokemon.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gudgie.pokemon.R;
import com.gudgie.pokemon.adapter.PokemonAdapter;
import com.gudgie.pokemon.model.NamedApiResource;
import com.gudgie.pokemon.model.PokemonNamedApiResource;
import com.gudgie.pokemon.presenter.MainPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity implements MainPresenter.View {

    @BindView(R.id.activity_main_pokemon_recyclerview) RecyclerView pokemonRecyclerView;

    @Inject PokemonAdapter pokemonAdapter;
    @Inject MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        pokemonRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        pokemonRecyclerView.setAdapter(pokemonAdapter);

        presenter.onViewCreated(this);
    }

    @Override
    public void setPokemonResources(List<PokemonNamedApiResource> pokemon) {
        pokemonAdapter.setPokemonResources(pokemon);
    }

}
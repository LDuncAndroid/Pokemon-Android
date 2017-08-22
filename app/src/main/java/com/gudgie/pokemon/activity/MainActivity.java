package com.gudgie.pokemon.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.gudgie.pokemon.R;
import com.gudgie.pokemon.presenter.MainPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity implements MainPresenter.View {

    @BindView(R.id.main_activity_pokemon_name) TextView pokemonName;

    @Inject MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter.onViewCreated(this);
    }

    @Override
    public void setFirstPokemonName(String name) {
        pokemonName.setText(name);
    }
}
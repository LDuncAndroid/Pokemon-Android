package com.gudgie.pokemon.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.gudgie.pokemon.R;
import com.gudgie.pokemon.presenter.PokemonListItemPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PokemonListItemView extends FrameLayout implements PokemonListItemPresenter.View {

    @BindView(R.id.view_pokemon_list_item_name) TextView pokemonNameView;
    @BindView(R.id.view_pokemon_list_item_image) ImageView pokemonImageView;

    private PokemonListItemPresenter presenter;

    public PokemonListItemView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    private void initialize() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_pokemon_list_item, this, true);
        ButterKnife.bind(this);
        presenter = new PokemonListItemPresenter();
        presenter.onViewCreated(this);
    }

    public void bind(ViewModel data) {
        presenter.bind(data);
    }

    @Override
    public void setName(String name) {
        pokemonNameView.setText(name);
    }

    public interface ViewModel {

        String getName();

        String getUrl();

    }

}

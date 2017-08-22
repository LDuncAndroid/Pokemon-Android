package com.gudgie.pokemon.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gudgie.pokemon.R;
import com.gudgie.pokemon.model.NamedApiResource;
import com.gudgie.pokemon.model.PokemonNamedApiResource;
import com.gudgie.pokemon.view.PokemonListItemView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {

    private List<PokemonNamedApiResource> pokemonResources = new ArrayList<>();

    @Inject
    PokemonAdapter() {}

    @Override
    public PokemonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PokemonViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_pokemon_item, parent, false));
    }

    @Override
    public void onBindViewHolder(PokemonViewHolder holder, int position) {
        holder.bind(pokemonResources.get(position));
    }

    @Override
    public int getItemCount() {
        return pokemonResources.size();
    }

    public void setPokemonResources(List<PokemonNamedApiResource> pokemonResources) {
        this.pokemonResources = pokemonResources;
        notifyDataSetChanged();
    }

    class PokemonViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.adapter_pokemon_item_view) PokemonListItemView pokemonListItemView;

        PokemonViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(NamedApiResource pokemon) {
            pokemonListItemView.bind(pokemon);
        }

    }

}

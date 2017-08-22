package com.gudgie.pokemon.presenter;

import com.gudgie.pokemon.view.BaseView;
import com.gudgie.pokemon.view.PokemonListItemView;

/**
 * Created by luke on 23/08/17.
 */

public class PokemonListItemPresenter extends BasePresenter<PokemonListItemPresenter.View> {

    public PokemonListItemPresenter() {
    }

    public void bind(PokemonListItemView.ViewModel data) {
        getView().setName(data.getName());
    }

    public interface View extends BaseView {

        void setName(String name);

    }

}

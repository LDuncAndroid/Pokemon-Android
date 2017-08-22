package com.gudgie.pokemon.di;

import com.gudgie.pokemon.PokemonApplication;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Component(modules = {AndroidInjectionModule.class, ApplicationModule.class})
public interface ApplicationComponent extends AndroidInjector<PokemonApplication> {
}
package com.gudgie.pokemon.di;

import com.gudgie.pokemon.activity.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ApplicationModule {

    @ContributesAndroidInjector
    abstract MainActivity contributeActivityInjector();

}
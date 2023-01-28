package com.example.musicapp.di

import com.example.musicapp.presenter.*
import dagger.Binds
import dagger.Module

@Module
abstract class PresentersModule {

    @Binds
    abstract fun providesRockPresenter(
        peoplePresenter: RockPresenter
    ): RockPresenterContract

    @Binds
    abstract fun providesPopPresenter(
        planetsPresenter: PopPresenter
    ): PopPresenterContract

    @Binds
    abstract fun providesClassicPresenter(
        starshipPresenter: ClassicPresenter
    ): ClassicPresenterContract
}
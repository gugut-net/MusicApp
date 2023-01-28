package com.example.musicapp.di

import com.example.musicapp.model.rest.MusicRepository
import com.example.musicapp.model.rest.MusicRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindsMusicsRepository(
        musicRepositoryImpl: MusicRepositoryImpl
    ): MusicRepository
}
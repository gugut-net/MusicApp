package com.example.musicapp.di

import android.app.Application

class MusicApp: Application() {

    override fun onCreate() {
        super.onCreate()
        // Dagger + StarWarsComponent
        musicComponent = DaggerMusicComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    companion object {
        lateinit var musicComponent: MusicComponent
    }
}
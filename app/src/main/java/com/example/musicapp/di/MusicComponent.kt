package com.example.musicapp.di


import com.example.MainActivity
import com.example.musicapp.view.ClassicFragment
import com.example.musicapp.view.PopFragment
import com.example.musicapp.view.RockFragment
import dagger.Component

@Component(modules = [
    NetworkModule::class,
    RepositoryModule::class,
    ApplicationModule::class,
    PresentersModule::class
])
interface MusicComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(rockFragment: RockFragment)
    fun inject(popFragment: PopFragment)
    fun inject(classicFragment: ClassicFragment)
}
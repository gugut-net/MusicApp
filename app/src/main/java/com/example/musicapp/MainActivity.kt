package com.example.musicapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.musicapp.model.view.Communicator
import com.example.musicapp.model.view.DisplayFragment
import com.example.musicapp.model.view.SearchFragment
import com.example.musicapp.model.view.adapter.MusicsAdapter

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity(), Communicator {

    private lateinit var musicList: RecyclerView
    private lateinit var adapter: MusicsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Hides action bar
         */
        supportActionBar?.hide()

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_search, SearchFragment())
            .commit()

    }

    override fun sendDataToSearch(
        musicTitle: String) {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_display,
                DisplayFragment.newInstance(musicTitle))
                .addToBackStack("")
                .commit()
        }
    }


package com.example.musicapp

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {


    private lateinit var artist_textView: TextView
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.play_list_item)

        supportActionBar?.hide()

        mediaPlayer = MediaPlayer()

        artist_textView = findViewById(R.id.artist_textView)

        val artist = intent.getStringExtra("ALBUM")
        artist_textView.text = artist

        val song_paly = intent.getStringExtra("SONG_PLAY")

        mediaPlayer.setDataSource(song_paly)
        mediaPlayer.prepare()
        mediaPlayer.start()

    }
}
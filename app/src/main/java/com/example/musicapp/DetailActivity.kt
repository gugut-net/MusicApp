package com.example.musicapp

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.musicapp.model.Music
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {


    private lateinit var artist_textView: TextView
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var album_imageCover: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.play_list_item)

        /**
         * Hides actionbar menu
         */
        supportActionBar?.hide()





        artist_textView = findViewById(R.id.artist_textView)
        album_imageCover = findViewById(R.id.album_imageView)


        val artist = intent.getStringExtra("ALBUM")
        artist_textView.text = artist

        /**
         * Intent
         * intent put extra
         */
        val songPlay = intent.getStringExtra("SONG_PLAY")
        val songCover = intent.getStringExtra("ALBUM_COVER")

        /**
         * Media Player
         */
        mediaPlayer = MediaPlayer()
        mediaPlayer.setDataSource(songPlay)
        mediaPlayer.prepare()
        mediaPlayer.start()


        /**
         * Picasso image
         */
        Picasso.get()
            .load(songCover)
            .resize(300,300)
            .into(album_imageCover)


    }

}
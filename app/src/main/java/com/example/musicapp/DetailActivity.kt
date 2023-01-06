package com.example.musicapp

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso


class DetailActivity : AppCompatActivity() {


    private lateinit var artist_textView: TextView
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var album_imageCover: ImageView
    private lateinit var mPlayer: ImageButton
    private var isPlaying = true
    private lateinit var seekBar: SeekBar
    private var int = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.play_list_item)

        /**
         * Hides actionbar menu
         */
        supportActionBar?.hide()


        artist_textView = findViewById(R.id.artist_textView)
        album_imageCover = findViewById(R.id.album_imageView)
//        seekBar = findViewById(R.id.seekBar)

        /**
         * Initiate onclick listener
         */
        mPlayer = findViewById(R.id.play_button)
//        mPlayer.setOnClickListener(listener)
//        seekBar.setOnSeekBarChangeListener(seekBar)


        val artist = intent.getStringExtra("ALBUM")
        artist_textView.text = artist

        /**
         * Intent
         * intent put extra
         */
        val songPlay = intent.getStringExtra("SONG_PLAY")
        val songCover = intent.getStringExtra("ALBUM_COVER")

        /**
         * Media Player event
         */
        mediaPlayer = MediaPlayer()
        mediaPlayer.setDataSource(songPlay)
        mediaPlayer.prepare()
        mediaPlayer.start()


        /**
         * Picasso image event
         */
        Picasso.get()
            .load(songCover)
            .resize(400, 355)
            .into(album_imageCover)


        /**
         * Set on click listener event on play and pause button
         */
        mPlayer.setOnClickListener {
            if (isPlaying) {
                mediaPlayer.pause()
                 int = mediaPlayer.currentPosition
                isPlaying = false
                mPlayer.setBackgroundResource(R.drawable.play)

            } else {
                mediaPlayer.start()
                isPlaying = true
                mPlayer.setBackgroundResource(R.drawable.pause)
            }
        }

    }

}
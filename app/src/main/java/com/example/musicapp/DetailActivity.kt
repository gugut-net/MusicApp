package com.example.musicapp

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.gugutmusic.R
import com.squareup.picasso.Picasso
import java.util.*

private const val TAG = "DetailActivity"

class DetailActivity : AppCompatActivity() {


    private lateinit var artist_textView: TextView
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var album_imageCover: ImageView
    private lateinit var mPlayer: ImageButton
    private lateinit var seekBar: SeekBar
    private lateinit var backArrow: ImageButton
    private lateinit var forwardButton: ImageButton
    private lateinit var rewindButton: ImageButton
    private var isPlaying = true
    val song_play = LinkedList<String>()

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
        backArrow = findViewById(R.id.back_arrow)
        forwardButton = findViewById(R.id.forward_button)
        rewindButton = findViewById(R.id.rewind_button)
        seekBar = findViewById(R.id.seekBar)

//        val song = intent.getStringExtra("LIST")
//
//        for(i in 49 until 50){
//            Log.d(TAG, "Artist: ${song}")
//        }

        /**
         * Initiate onclick listener
         */
        mPlayer = findViewById(R.id.play_button)

        /**
         *  Seekbar event progress
         */
        seekBar.progress


        val artist = intent.getStringExtra("ALBUM")
        artist_textView.text = artist

        /**
         * Forward button event
         */
        forwardButton.setOnClickListener {
            if (!isPlaying) {
                mediaPlayer.currentPosition

            }
        }

        /**
         * Rewind button event
         */
        rewindButton.setOnClickListener {
            if (isPlaying) {
                mediaPlayer.start()

            }
        }

        /**
         * App bar back arrow event
         */
        backArrow.setOnClickListener {
            if (isPlaying) {
                mediaPlayer.pause()
            }
            finish()
        }

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
         * Initiated in MusicAdapter class with intent and putExtra
         */
        Picasso.get()
            .load(songCover)
            .resize(450, 375)
            .into(album_imageCover)

        /**
         * Set on click listener event on play and pause button
         * Implemented play and pause image resource
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
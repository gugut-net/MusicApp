package com.example

import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.gugutmusicmvp.R
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    private lateinit var album_name: TextView
    private lateinit var mPlayer: ImageButton
    private lateinit var album_imageCover: ImageView
    private var mediaPlayer: MediaPlayer? = null
    private lateinit var seekBarProgress: SeekBar
    private lateinit var backArrow: ImageButton
    private lateinit var forwardButton: ImageButton
    private lateinit var rewindButton: ImageButton
    private lateinit var play_music: ImageButton
    private lateinit var pause_button: ImageButton
    private lateinit var song_name: TextView
    private lateinit var artist_name: TextView

    private var int = 0
    var isPlaying = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_detail)

        /**
         * Hides actionbar menu
         */
        supportActionBar?.hide()

        val album = intent.getStringExtra("ALBUM_EXTRA")
        val song = intent.getStringExtra("SONG_EXTRA")
        val musicUrl = intent.getStringExtra("SONG_URL_EXTRA")
        val artist = intent.getStringExtra("SONG_ARTIST")
        val cover = intent.getStringExtra("COVER_EXTRA")


        album_name = findViewById(R.id.album_name)
        album_imageCover = findViewById(R.id.album_imageView)
        backArrow = findViewById(R.id.back_arrow)
        play_music = findViewById(R.id.play_button)
        forwardButton = findViewById(R.id.forward_button)
        rewindButton = findViewById(R.id.rewind_button)
        seekBarProgress = findViewById(R.id.seekBar)
        pause_button = findViewById(R.id.pause_button)
        song_name = findViewById(R.id.song_name)
        artist_name = findViewById(R.id.artist_name)

        /**
         * Initiate onclick listener
         */
        mPlayer = findViewById(R.id.stop_button)

        mediaPlayer = MediaPlayer()
        mediaPlayer?.setAudioStreamType(AudioManager.STREAM_MUSIC)
        mediaPlayer?.setDataSource(musicUrl)
        mediaPlayer?.prepare()

        /**
         * App bar back arrow event
         */
        backArrow.setOnClickListener {
            if (isPlaying) {
                mediaPlayer?.pause()
            }
            finish()
        }

        Picasso.get()
            .load(cover)
            .resize(500,500)
            .into(album_imageCover)

        album_name.text = "Album: $album"
        song_name.text = "Song: $song"
        artist_name.text = "Artis: $artist"

        /**
         * Set on click listener event on play and pause button
         * Implemented play and pause image resource
         */
        pause_button.setOnClickListener {
            if (isPlaying) {
                mediaPlayer?.pause()
                int = mediaPlayer?.currentPosition!!
                isPlaying = false
                pause_button.setBackgroundResource(R.drawable.play)
            } else {
                mediaPlayer!!.start()
                isPlaying = true
                pause_button.setBackgroundResource(R.drawable.pause)
            }
        }
    }
}
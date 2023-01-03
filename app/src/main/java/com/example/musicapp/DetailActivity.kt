package com.example.musicapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_FIRST_NAME = "EXTRA_FIRST_NAME"
        const val EXTRA_LAST_NAME = "EXTRA_LAST_NAME"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.play_list_item)

    }
}
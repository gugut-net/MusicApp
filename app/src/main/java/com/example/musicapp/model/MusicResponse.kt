package com.example.musicapp.model

data class MusicResponse(
    val resultCount: Int,
    val results: List<Music>
)

data class Music(
    val artistName: String,
    val collectionName: String,
    val trackName: String,
    val artworkUrl100: String,
    val previewUrl: String,
    val songCover: String,
    val backArrow: String
)

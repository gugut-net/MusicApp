package com.example.musicapp.model


/**
 * Initiated Music Service and DisplayFragment
 */
data class MusicResponse(
    val resultCount: Int,
    val results: List<Music>
)

/**
 * Initiated in MusicResponse and MusicAdapter
 */
data class Music(
    val artistName: String,
    val collectionName: String,
    val trackName: String,
    val artworkUrl100: String,
    val previewUrl: String,
    val songCover: String,
    val backArrow: String,
    val rewindButton: String,
    val forwardButton: String
)

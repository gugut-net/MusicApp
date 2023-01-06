package com.example.musicapp.model.remote

import com.example.musicapp.model.MusicResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MusicService  {

    /**
     * Receive data search from Constants kotlin file
     * Sends API information to the DisplayFragment class
     */
    @GET(ENDPOINT)
    fun getNextMusicPage(
        @Query(PARAM_Q) musicTitle: String,


    ): Call<MusicResponse>
}
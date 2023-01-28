package com.example.musicapp.model.rest


import com.example.musicapp.model.GeneralResponse
import com.example.musicapp.model.utils.ENDPOINT
import com.example.musicapp.model.utils.TERM
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MusicAPI {
    @GET(ENDPOINT)
    suspend fun getGender(
        @Query(TERM) musicGender: String
    ): Response<GeneralResponse>
}
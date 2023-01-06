package com.example.musicapp.model.view

interface Communicator {


    /**
     * Send data to SearchFragment class
     * and is call in by sendParams function
     */
    fun sendDataToSearch(
        musicTitle: String
    )
}
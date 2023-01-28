package com.example.musicapp.model.utils

import com.example.musicapp.model.GeneralResponse


sealed class UIState {
    object LOADING : UIState()
    data class SUCCESS(val response: GeneralResponse) : UIState()
    class ERROR(val e: Exception) : UIState()
}

package com.example.musicapp.model.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.musicapp.databinding.SearchFragmentBinding

class SearchFragment : Fragment() {


    private lateinit var binding: SearchFragmentBinding
    private lateinit var  musicGenre: String

    private lateinit var communicator: Communicator

    override fun onAttach(context: Context) {
        super.onAttach(context)
        when(context) {
            is Communicator -> communicator = context
            else -> throw Exception("Incorrect Host Activity")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = SearchFragmentBinding.inflate(
            inflater,
            container,
            false
        )
        initViews()

        return binding.root
    }

    private fun initViews() {
        binding.apply {
            popMusicTab.setOnClickListener {
                musicGenre = "pop"
                sendSearchParams()
            }
            rockMusicTab.setOnClickListener {
                musicGenre = "rock"
                sendSearchParams()
            }
            rnbMusicItem.setOnClickListener {
                musicGenre = "rnb"
                sendSearchParams()
            }
            classicMusicItem.setOnClickListener {
                musicGenre = "classic"
                sendSearchParams()
            }
        }
    }

    private fun sendSearchParams() {
        communicator.sendDataToSearch(musicGenre)
    }



}
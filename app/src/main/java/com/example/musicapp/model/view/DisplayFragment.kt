package com.example.musicapp.model.view

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicapp.databinding.DisplayFragmentBinding
import com.example.musicapp.model.MusicResponse
import com.example.musicapp.model.remote.Network
import com.example.musicapp.model.view.adapter.MusicsAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "DisplayFragment"

class DisplayFragment : Fragment() {
    companion object {
        const val EXTRA_MUSIC = "EXTRA_MUSIC"

        fun newInstance(musicTitle: String) = DisplayFragment().apply {
            arguments = Bundle().apply {
                putString(EXTRA_MUSIC, musicTitle)

            }
        }
    }
    private lateinit var binding: DisplayFragmentBinding
    private lateinit var musicTitle: String
    private val adapter: MusicsAdapter by lazy {
        MusicsAdapter(mutableListOf())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         super.onCreateView(inflater, container, savedInstanceState)
        binding = DisplayFragmentBinding.inflate(
            inflater,
            container,
            false
        )
        arguments?.let {
            musicTitle = it.getString(EXTRA_MUSIC) ?: " "

            getMusicsData(musicTitle)
        }
        initViews()
        return binding.root
    }

    private fun getMusicsData(musicTitle: String) {
        Network().api
            .getNextMusicPage(musicTitle)
            .enqueue(
                object : Callback<MusicResponse> {
                    override fun onResponse(
                        call: Call<MusicResponse>,
                        response: Response<MusicResponse>
                    ) {
                        if (response.isSuccessful) {
                            response.body()?.let {
                                updateAdapter(it)
                            }
                        }else {
                            Log.d(TAG, "onResponse: : ${response.message()}")
                        }
                    }

                    override fun onFailure(call: Call<MusicResponse>, t: Throwable) {
                        Log.d(TAG, "onFailure: ${t.message}")
                        t.printStackTrace()
                    }
                }
            )
    }
    private fun initViews() {
        binding.apply {
            musicListResult.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            musicListResult.adapter = adapter

//            musicListResult.addOnScrollListener(scrollListener)

        }
    }
//    private val scrollListener = object : RecyclerView.OnScrollListener() {
//
//    }
    private fun updateAdapter(dataSet: MusicResponse) {
        adapter.updateDataSet(dataSet.results)
    }
}
package com.example.musicapp.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.DetailActivity
import com.example.gugutmusicmvp.databinding.FragmentGeneralBinding
import com.example.musicapp.di.MusicApp
import com.example.musicapp.model.GeneralResponse
import com.example.musicapp.presenter.PopPresenterContract
import com.example.musicapp.presenter.PopViewContract
import com.example.musicapp.view.adapter.MusicAdapter
import javax.inject.Inject

class PopFragment : Fragment(), PopViewContract {
    @Inject
    lateinit var presenter: PopPresenterContract

    private val adapter: MusicAdapter by lazy {
        MusicAdapter(mutableListOf()){ music ->
            with(Intent(requireContext(), DetailActivity::class.java)){
                putExtra("ALBUM_EXTRA", music.collectionName)
                putExtra("SONG_EXTRA", music.trackName)
                putExtra("COVER_EXTRA", music.artworkUrl100)
                putExtra("SONG_URL_EXTRA", music.previewUrl)
                putExtra("SONG_ARTIST", music.artistName)

                startActivity(this)
            }
        }
    }
    private val binding: FragmentGeneralBinding by lazy {
        FragmentGeneralBinding.inflate(
            layoutInflater
        )
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        MusicApp.musicComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        initViews()
        presenter.initPresenter(this)
        presenter.getPopData(lifecycleScope)
        return binding.root
    }

    private fun initViews() {
        binding.apply {
            listResponse.layoutManager = LinearLayoutManager(context)
            listResponse.adapter = adapter
        }
    }

    override fun onStop() {
        super.onStop()
        presenter.destroyPresenter()
    }

    override fun success(response: GeneralResponse) {
        adapter.updateDataSet(response.results)
    }

    override fun error(ex: Exception) {
        Toast.makeText(context, ex.message, Toast.LENGTH_SHORT).show()
    }

    override fun loading() {

    }
}
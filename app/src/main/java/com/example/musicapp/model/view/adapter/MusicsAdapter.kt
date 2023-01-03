package com.example.musicapp.model.view.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicapp.databinding.MusicItemLayoutBinding
import com.example.musicapp.model.Music
import com.squareup.picasso.Picasso


class MusicsAdapter(private val dataSet: MutableList<Music>): RecyclerView.Adapter<MusicsAdapter.MusicViewHolder>() {

    class MusicViewHolder(private val binding: MusicItemLayoutBinding):
            RecyclerView.ViewHolder(binding.root) {
                fun onBind(musicItem: Music) {
                    binding.apply {
                        musicTitleItem.text = musicItem.collectionName
                        musicAlbumItem.text = musicItem.trackName
                        musicArtisItem.text = musicItem.artistName
                        Picasso.get().load(musicItem.artworkUrl100).resize(300,300).into(musicCoverItem)
                    }
                }

            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MusicViewHolder(
            MusicItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        holder.onBind(dataSet[position])
    }

    override fun getItemCount() = dataSet.size

    fun updateDataSet(items: List<Music>) {
        val originalSize = dataSet.size - 1
        dataSet.addAll(items)
        notifyItemRangeInserted(originalSize, 10)

    }
}



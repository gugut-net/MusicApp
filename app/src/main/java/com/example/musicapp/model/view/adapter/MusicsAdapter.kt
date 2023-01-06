package com.example.musicapp.model.view.adapter


import android.content.Intent
import android.media.MediaPlayer
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gugutmusic.R
import com.example.gugutmusic.databinding.MusicItemLayoutBinding
import com.example.musicapp.DetailActivity
import com.example.musicapp.model.Music
import com.squareup.picasso.Picasso
import java.util.LinkedList

lateinit var mediaPlayer: MediaPlayer

private const val TAG = "MusicsAdapter"

class MusicsAdapter(private val dataSet: MutableList<Music>): RecyclerView.Adapter<MusicsAdapter.MusicViewHolder>() {

    class MusicViewHolder(private val binding: MusicItemLayoutBinding):
            RecyclerView.ViewHolder(binding.root) {
                fun onBind(musicItem: Music) {
                    binding.apply {
                        musicTitleItem.text = musicItem.collectionName
                        musicAlbumItem.text = musicItem.trackName
                        musicArtisItem.text = musicItem.artistName
                        musicAlbumItem.text = musicItem.songCover

                        Picasso.get().load(musicItem.artworkUrl100)
                            .resize(300,300)
                            .into(musicCoverItem)
                    }
                }
        val itemAlbum: TextView = binding.root.findViewById(R.id.music_album_item)
        val itemTitle: TextView = binding.root.findViewById(R.id.music_title_item)

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
        mediaPlayer = MediaPlayer()
        holder.onBind(dataSet[position])
        holder.itemAlbum.text = dataSet[position].collectionName
        holder.itemTitle.text = dataSet[position].trackName

        val i = 0
        val end = 49

        val song = LinkedList<String>()

        for(i in end until 50){
            song.add(dataSet[i].artistName)
            Log.d(TAG, "Song: ${dataSet[i].artistName}")
        }

        /**
         * Set setOnClickListener
         * intent putExtra to call in DetailActivity
         */
        holder.itemView.setOnClickListener { v ->
            val intent = Intent(v.context, DetailActivity::class.java)
            intent.putExtra("ALBUM", holder.itemAlbum.text)
            intent.putExtra("SONG_PLAY", dataSet[position].previewUrl)
            intent.putExtra("ALBUM_COVER", dataSet[position].artworkUrl100)
            intent.putExtra("BACK_ARROW",dataSet[position].backArrow)
            intent.putExtra("FORWARD_BUTTON", dataSet[position].forwardButton)
            intent.putExtra("REWIND_BUTTON",dataSet[position].rewindButton)
            intent.putExtra("LIST", song)
            v.context.startActivity(intent)

        }
    }

    override fun getItemCount() = dataSet.size

    fun updateDataSet(items: List<Music>) {
        val originalSize = dataSet.size - 1
        dataSet.addAll(items)
        notifyItemRangeInserted(originalSize, 10)

    }
}



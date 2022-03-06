package com.example.youtubeapi38.ui.playlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeapi38.R
import com.example.youtubeapi38.databinding.ItemPlaylistBinding
import com.example.youtubeapi38.core.extensions.glide
import com.example.youtubeapi38.data.model.Items

class PlaylistAdapter(private val onClickVideo: (id: String) -> Unit) :
    RecyclerView.Adapter<PlaylistAdapter.ViewHolder>() {
    private var playlist = listOf<Items>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemPlaylistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(playlist[position])
    }

    override fun getItemCount(): Int {
        return playlist.size
    }

    fun setPlaylist(playlist: List<Items>) {
        this.playlist = playlist
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemPlaylistBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(playlist: Items) {
            binding.apply {
                tvCount.text = String.format(itemView.context.getString(R.string.video_series), playlist.contentDetails.itemCount.toString())
                tvTitle.text = playlist.snippet.title
                ivPlaylist.glide(playlist.snippet.thumbnails.high.url)
                channelTitle.text = playlist.snippet.channelTitle
                itemView.setOnClickListener {
                    onClickVideo(playlist.id)
                }
            }
        }
    }
}
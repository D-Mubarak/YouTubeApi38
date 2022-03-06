package com.example.youtubeapi38.ui.playlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeapi38.R
import com.example.youtubeapi38.databinding.ItemPlaylistBinding
import com.example.youtubeapi38.core.extensions.glide
import com.example.youtubeapi38.data.model.Items

class PlaylistAdapter(private val playlist: List<Items>,  private val onClickVideo: (id: String) -> Unit) :
    RecyclerView.Adapter<PlaylistAdapter.ViewHolder>() {

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

    inner class ViewHolder(private val binding: ItemPlaylistBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(items: Items) {
            binding.apply {
                tvCount.text = String.format(itemView.context.getString(R.string.video_series), items.contentDetails.itemCount.toString())
                tvTitle.text = items.snippet.title
                ivPlaylist.glide(items.snippet.thumbnails.high.url)
                channelTitle.text = items.snippet.channelTitle
                itemView.setOnClickListener {
                    onClickVideo(items.id)
                }
            }
        }
    }
}
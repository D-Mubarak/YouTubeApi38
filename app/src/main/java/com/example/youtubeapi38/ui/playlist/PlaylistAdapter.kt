package com.example.youtubeapi38.ui.playlist.item

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.youtubeapi38.databinding.ItemPlaylistBinding
import com.example.youtubeapi38.model.Items

class PlaylistAdapter : RecyclerView.Adapter<PlaylistAdapter.ViewHolder>() {
    private var playlist = listOf<Items>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistAdapter.ViewHolder {
        val binding =
            ItemPlaylistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(playlist[position])
    }

    override fun getItemCount(): Int = playlist.size

    fun setPlaylist(playlist: List<Items>) {
        this.playlist = playlist
        notifyDataSetChanged()
    }


    inner class ViewHolder(private val binding: ItemPlaylistBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(playlist: Items) {
            binding.apply {
                tvCount.text = playlist.contentDetails.itemCount.toString()
                tvTitle.text = playlist.snippet.title
                Glide.with(root).load(playlist.snippet.thumbnails.high.url).into(ivPlaylist)
            }
        }
    }
}
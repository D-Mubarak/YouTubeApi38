package com.example.youtubeapi38.ui.playlist

import android.content.Intent
import android.view.LayoutInflater
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.youtubeapi38.core.network.result.Status
import com.example.youtubeapi38.core.ui.BaseActivity
import com.example.youtubeapi38.data.model.Playlist
import com.example.youtubeapi38.databinding.ActivityPlaylistBinding
import com.example.youtubeapi38.ui.detail.DetailActivity

class PlaylistActivity : BaseActivity<ViewModel, ActivityPlaylistBinding>() {
    companion object {
        const val ID = "id"
    }

    override val viewModel: ViewModel by lazy {
        ViewModelProvider(this)[ViewModel::class.java]
    }

    override fun initViewModel() {
        super.initViewModel()

        viewModel.loading.observe(this) {
            binding.progressBar.isVisible = it
        }
        viewModel.getPlaylists().observe(this) {
            when (it.status) {
                Status.LOADING -> viewModel.loading.postValue(true)
                Status.SUCCESS -> {
                    initRv(it.data)
                    viewModel.loading.postValue(false)
                }
                Status.ERROR -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                    viewModel.loading.postValue(false)
                }
            }
        }
    }

    private fun initRv(playlist: Playlist?) {
        binding.playlistRv.layoutManager = LinearLayoutManager(this)
        binding.playlistRv.adapter = playlist?.items?.let { PlaylistAdapter(it, this::listener) }
    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityPlaylistBinding {
        return ActivityPlaylistBinding.inflate(inflater)
    }

    fun listener(id: String) {
        Intent(this@PlaylistActivity, DetailActivity::class.java).apply {
            putExtra(ID, id)
            startActivity(this)
        }
    }
}
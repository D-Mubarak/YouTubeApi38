package com.example.youtubeapi38.ui.playlist.item

import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeapi38.base.BaseActivity
import com.example.youtubeapi38.databinding.ActivityNoInternetBinding
import com.example.youtubeapi38.ui.playlist.PlaylistsViewModel

class NoInternetActivity: BaseActivity<PlaylistsViewModel, ActivityNoInternetBinding>() {
    override val viewModel: PlaylistsViewModel by lazy{
        ViewModelProvider(this)[PlaylistsViewModel::class.java]
    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityNoInternetBinding {
        return ActivityNoInternetBinding.inflate(inflater)
    }
}
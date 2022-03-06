package com.example.youtubeapi38.ui.detail

import android.view.LayoutInflater
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeapi38.core.ui.BaseActivity
import com.example.youtubeapi38.databinding.ActivityDetailBinding
import com.example.youtubeapi38.ui.playlist.PlaylistActivity.Companion.ID
import com.example.youtubeapi38.ui.playlist.ViewModel

class DetailActivity : BaseActivity<ViewModel, ActivityDetailBinding>(){
    override val viewModel: ViewModel by lazy {
        ViewModelProvider(this)[ViewModel::class.java]
    }


    override fun initViewModel() {
        super.initViewModel()
        viewModel.getPlaylists().observe(this){
            val id = intent.getStringExtra(ID).toString()
            Toast.makeText(this, id, Toast.LENGTH_SHORT).show()
        }
    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityDetailBinding {
        return ActivityDetailBinding.inflate(inflater)
    }
}
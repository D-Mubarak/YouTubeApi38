package com.example.youtubeapi38.ui.playlist

import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeapi38.core.ui.BaseActivity
import com.example.youtubeapi38.databinding.ActivityNoInternetBinding

class NoInternetActivity: BaseActivity<ViewModel, ActivityNoInternetBinding>() {
    override val viewModel: ViewModel by lazy{
        ViewModelProvider(this)[ViewModel::class.java]
    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityNoInternetBinding {
        return ActivityNoInternetBinding.inflate(inflater)
    }
}
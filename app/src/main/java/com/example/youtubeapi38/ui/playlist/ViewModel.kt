package com.example.youtubeapi38.ui.playlist

import androidx.lifecycle.LiveData
import com.example.youtubeapi38.App
import com.example.youtubeapi38.core.network.result.Resource
import com.example.youtubeapi38.core.ui.BaseViewModel
import com.example.youtubeapi38.data.model.Playlist

class ViewModel : BaseViewModel() {

    fun getPlaylists(): LiveData<Resource<Playlist>> {
        return App().repository.getPlaylists()
    }

}
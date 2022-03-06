package com.example.youtubeapi38.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtubeapi38.BuildConfig
import com.example.youtubeapi38.utils.Constant
import com.example.youtubeapi38.data.model.Playlist
import com.example.youtubeapi38.data.remote.ApiService
import com.example.youtubeapi38.core.network.RetrofitClient
import com.example.youtubeapi38.core.network.result.Resource
import kotlinx.coroutines.flow.callbackFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    private val apiService: ApiService by lazy {
        RetrofitClient.create()
    }

    fun getPlaylists(): LiveData<Resource<Playlist>> {
        val data = MutableLiveData<Resource<Playlist>>()
        data.value = Resource.loading()
        apiService.getPlaylists(
            Constant.part,
            Constant.channelId,
            BuildConfig.API_KEY,
            Constant.maxResult
        )
            .enqueue(object : Callback<Playlist> {
                override fun onResponse(call: Call<Playlist>, response: Response<Playlist>) {
                    if (response.isSuccessful) {
                        data.value = Resource.success(response.body())
                    }
                }

                override fun onFailure(call: Call<Playlist>, t: Throwable) {
                    data.value = Resource.error(t.message)
                }
            })
        return data
    }
}
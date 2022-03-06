package com.example.youtubeapi38

import android.app.Application
import com.example.youtubeapi38.repository.Repository

class App: Application() {
    val repository:Repository by lazy {
        Repository()
    }
}
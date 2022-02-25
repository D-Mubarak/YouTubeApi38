package com.example.youtubeapi38.ui.playlist

import android.view.LayoutInflater
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeapi38.base.BaseActivity
import com.example.youtubeapi38.databinding.ActivityPlaylistBinding

class PlaylistActivity : BaseActivity<PlaylistsViewModel,ActivityPlaylistBinding>() {

    override val viewModel: PlaylistsViewModel by lazy {
        ViewModelProvider(this)[PlaylistsViewModel::class.java]
    }

    override fun initViewModel() {
        super.initViewModel()

        viewModel.playlists().observe(this) {
            Toast.makeText(this,it.kind,Toast.LENGTH_SHORT).show()
        }
    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityPlaylistBinding {
        return ActivityPlaylistBinding.inflate(inflater)
    }
}

/*
*
Дз.
 1. Создать свой ApiKey и ознакомиться с документацией
 2. Добавить в класс playlist поле "items", отрисовать первых 2 экрана из фигмы (Проверка на интернет, и список всех PlayList)
 3. Cделать переход на новую активити и передаете туда id и её отображаете тостом

Также прочитайте про корутины желательно

Доп: в PlayListActivity попробуйте реализовать пагинацию с помощью ViewType с RecyclerView

*
* */
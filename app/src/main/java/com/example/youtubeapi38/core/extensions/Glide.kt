package com.example.youtubeapi38.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.glide(url : String){
    Glide.with(this).load(url).into(this)
}
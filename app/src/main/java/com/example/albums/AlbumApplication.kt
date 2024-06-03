package com.example.albums

import android.app.Application
import com.example.albums.di.AppContainer
import com.example.albums.di.DefaultAppContainer

class AlbumApplication: Application() {

    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}
package com.example.myapplication1234

import android.app.Application
import com.example.myapplication1234.di.AppContainer
import com.example.myapplication1234.di.DefaultAppContainer

class BookshelfApplication: Application() {

    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}
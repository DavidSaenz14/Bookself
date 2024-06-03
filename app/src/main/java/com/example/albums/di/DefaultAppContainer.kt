package com.example.albums.di


import com.example.albums.data.AlbumRepository
import com.example.albums.data.DefaultAlbumRepository
import com.example.albums.network.AlbumApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class DefaultAppContainer : AppContainer {
    override val albumRepository: AlbumRepository
        get() = TODO("Not yet implemented")

    override val albumApiService: AlbumApiService by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(AlbumApiService.BASE_URL)
            .build()
            .create()
    }

    override val bookshelfRepository: AlbumRepository by lazy {
        DefaultAlbumRepository(albumApiService)
    }
}
package com.example.albums.di

import com.example.albums.data.AlbumRepository

import com.example.albums.network.AlbumApiService

interface AppContainer {
    abstract val albumRepository: AlbumRepository
    val albumApiService: AlbumApiService
    val bookshelfRepository: AlbumRepository
}
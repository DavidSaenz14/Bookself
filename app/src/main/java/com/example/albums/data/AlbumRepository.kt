package com.example.albums.data

import com.example.albums.model.Album



interface AlbumRepository {
    suspend fun getAlbums(query: String): List<Album>?

    suspend fun getAlbum(id: String): Album?
}
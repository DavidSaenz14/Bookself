package com.example.albums.data


import com.example.albums.model.Album

import com.example.albums.network.AlbumApiService


class DefaultAlbumRepository(
    private val albumApiService: AlbumApiService
) : AlbumRepository {
    override suspend fun getAlbums(query: String): List<Album>? {
        return try {
            val res = albumApiService.getAlbums(query)
            if (res.isSuccessful) {
                res.body()?.items ?: emptyList()
            } else {
                emptyList()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override suspend fun getAlbum(id: String): Album? {
        return try {
            val res = albumApiService.getAlbum(id)
            if (res.isSuccessful) {
                res.body()
            } else {
                null
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
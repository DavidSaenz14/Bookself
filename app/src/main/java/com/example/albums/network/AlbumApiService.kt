package com.example.albums.network

import com.example.albums.model.Album

import com.example.albums.model.QueryResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * A public interface that exposes the [getBooks] method
 */
interface AlbumApiService {

    companion object {
        const val BASE_URL = "https://itunes.apple.com/search?term=senderos&entity=album&attribute=albumTerm"
    }

    @GET("albums")
    suspend fun getAlbums(@Query("q") query: String): Response<QueryResponse>

    @GET("albums/{id}")
    suspend fun getAlbum(@Path("id") id: String): Response<Album>
}
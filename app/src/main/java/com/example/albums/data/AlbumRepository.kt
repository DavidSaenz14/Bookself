package com.example.albums.data

import com.example.albums.model.Album


/**
 * Repository retrieves volume data from underlying data source.
 */
interface AlbumRepository {
    /** Retrieves list of books from underlying data source */
    // Notes: List<Book>? NULLABLE
    suspend fun getAlbums(query: String): List<Album>?

    suspend fun getAlbum(id: String): Album?
}
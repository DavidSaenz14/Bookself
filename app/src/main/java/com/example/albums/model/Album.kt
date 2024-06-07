package com.example.albums.model

import kotlinx.serialization.Serializable

@Serializable
data class Album(
    val id: String,
    val name: String,
    val band: String,
    val albumInfo: AlbumInfo,

)




@Serializable
data class AlbumInfo(
    val title: String,
    val description: String,
    val imageLinks: ImageLinks? = null,
)

@Serializable
data class ImageLinks(
    val smallThumbnail: String,
    val thumbnail: String,
) {
    val httpsThumbnail : String
        get() = thumbnail.replace("http", "https")
}



package com.example.albums.model



import kotlinx.serialization.Serializable


@Serializable
data class QueryResponse(
    val items: List<Album>?,
    val totalItems: Int,
    val kind: String,
)

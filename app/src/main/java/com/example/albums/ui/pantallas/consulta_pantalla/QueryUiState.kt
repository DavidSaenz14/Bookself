package com.example.albums.ui.pantallas.consulta_pantalla

import com.example.albums.model.Album

sealed interface QueryUiState {
    data class Success(val albumList: List<Album>) : QueryUiState
    object Error : QueryUiState
    object Loading : QueryUiState
}
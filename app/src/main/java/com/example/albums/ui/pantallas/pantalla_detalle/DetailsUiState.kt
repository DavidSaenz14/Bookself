package com.example.albums.ui.pantallas.pantalla_detalle

import com.example.albums.model.Album

sealed interface DetailsUiState {
    data class Success(val bookItem: Album) : DetailsUiState
    object Error : DetailsUiState
    object Loading : DetailsUiState
}
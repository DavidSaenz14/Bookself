package com.example.myapplication1234.ui.screens.detail_screen

import com.example.myapplication1234.model.Book

sealed interface DetailsUiState {
    data class Success(val bookItem: Book) : DetailsUiState
    object Error : DetailsUiState
    object Loading : DetailsUiState
}
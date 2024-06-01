package com.example.myapplication1234.ui.screens.query_screen

import com.example.myapplication1234.model.Book

sealed interface QueryUiState {
    data class Success(val bookshelfList: List<Book>) : QueryUiState
    object Error : QueryUiState
    object Loading : QueryUiState
}
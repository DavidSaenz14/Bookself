package com.example.myapplication1234.ui.screens.favorite_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.myapplication1234.ui.screens.components.ErrorScreen
import com.example.myapplication1234.ui.screens.components.LoadingScreen
import com.example.myapplication1234.R
import com.example.myapplication1234.ui.screens.query_screen.GridList
import com.example.myapplication1234.ui.screens.query_screen.QueryUiState
import com.example.myapplication1234.ui.screens.query_screen.QueryViewModel

@Composable
fun FavoritesScreen(
    viewModel: QueryViewModel,
    bookshelfUiState: QueryUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column {
        if (!viewModel.favoriteBooks.isEmpty()) {
            when (bookshelfUiState) {
                is QueryUiState.Loading -> LoadingScreen(modifier)
                is QueryUiState.Success -> GridList(
                    bookshelfList = bookshelfUiState.bookshelfList,
                    viewModel = viewModel,
                    modifier = modifier,
                    onDetailsClick = { }
                )
                else -> ErrorScreen(retryAction, modifier)
            }
        } else {
            Box(modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(stringResource(R.string.NoFavoriteBooksText))
            }
        }
    }
}
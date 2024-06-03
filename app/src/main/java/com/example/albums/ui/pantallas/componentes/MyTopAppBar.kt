package com.example.albums.ui.pantallas.componentes

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.example.albums.AppDestinations


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(
    currentScreen: AppDestinations,
    canNavigateBack: Boolean,
    onNavigateUpClicked: () -> Unit
) {
    TopAppBar(
        title = { Text(text = currentScreen.title) },
        navigationIcon = {
            if (canNavigateBack){
                IconButton(
                    onClick = onNavigateUpClicked
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Try Again"
                    )
                }
            }
        }
    )
}
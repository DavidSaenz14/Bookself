package com.example.myapplication1234.ui.screens.menu_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MenuScreen(
    onSearchClick: () -> Unit,
    onFavClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(top = 32.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = onSearchClick
        ) {
            Text(text = "Buscar")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = onFavClick
        ) {
            Text(text = "Favorito")
        }
    }
}

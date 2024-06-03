package com.example.albums.ui.pantallas.pantalla_menu

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun MenuScreen(
    onSearchClick: () -> Unit
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
    }
}

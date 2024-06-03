package com.example.albums.ui.pantallas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.albums.ui.AlbumApp

import com.example.bookshelf.ui.theme.BookshelfTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BookshelfTheme {

                AlbumApp()
            }
        }
    }
}
package com.example.myapplication1234.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.myapplication1234.ui.BookshelfApp
import com.example.myapplication1234.ui.theme.BookshelfTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BookshelfTheme {

                BookshelfApp()
            }
        }
    }
}
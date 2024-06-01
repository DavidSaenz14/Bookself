package com.example.myapplication1234.di

import com.example.myapplication1234.data.BookshelfRepository
import com.example.myapplication1234.network.BookshelfApiService

interface AppContainer {
    val bookshelfApiService: BookshelfApiService
    val bookshelfRepository: BookshelfRepository
}
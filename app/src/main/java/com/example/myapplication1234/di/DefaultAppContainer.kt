package com.example.myapplication1234.di

import com.example.myapplication1234.data.BookshelfRepository
import com.example.myapplication1234.data.DefaultBookshelfRepository
import com.example.myapplication1234.network.BookshelfApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class DefaultAppContainer : AppContainer {
//    private val json = Json {
//        ignoreUnknownKeys = true
//        explicitNulls = false
//    }
    override val bookshelfApiService: BookshelfApiService by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
//            .addConverterFactory(json
//                    .asConverterFactory("application/json".toMediaType()))
            .baseUrl(BookshelfApiService.BASE_URL)
            .build()
            .create()
    }

    override val bookshelfRepository: BookshelfRepository by lazy {
        DefaultBookshelfRepository(bookshelfApiService)
    }
}
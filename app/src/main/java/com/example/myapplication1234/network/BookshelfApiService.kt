package com.example.myapplication1234.network

import com.example.myapplication1234.model.Book
import com.example.myapplication1234.model.QueryResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BookshelfApiService {

    companion object {
        const val BASE_URL = "https://performancepartners.apple.com/search-api"
    }

    @GET("volumes")
    suspend fun getBooks(@Query("q") query: String): Response<QueryResponse>

    @GET("volumes/{id}")
    suspend fun getBook(@Path("id") id: String): Response<Book>
}
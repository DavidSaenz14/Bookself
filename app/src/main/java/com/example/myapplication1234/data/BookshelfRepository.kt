package com.example.myapplication1234.data

import com.example.myapplication1234.model.Book


interface BookshelfRepository {


    suspend fun getBooks(query: String): List<Book>?

    suspend fun getBook(id: String): Book?
}
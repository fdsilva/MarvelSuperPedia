package com.example.marvelsuperpedia.service

import com.example.marvelsuperpedia.model.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelAPI {
    @GET
    suspend fun getAllCharacters(@Query("offset") offset: Int? = 0): Response
}
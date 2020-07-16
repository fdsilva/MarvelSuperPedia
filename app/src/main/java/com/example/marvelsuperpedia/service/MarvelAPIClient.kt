package com.example.marvelsuperpedia.service

import com.example.marvelsuperpedia.utils.BASE_URL
import com.example.marvelsuperpedia.utils.getTimeStamp
import com.example.marvelsuperpedia.utils.md5
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MarvelAPIClient {

    fun getService(): MarvelAPI {
        val httpClient = OkHttpClient.Builder()
        val timeStamp = getTimeStamp()
        val hash = "".md5()

        httpClient.addInterceptor{
            val request = it.request()
            val requestURL = request.url()

            val url = requestURL.newBuilder()
                .addQueryParameter("ts", timeStamp)
                .addQueryParameter("apiKey", "")
                .addQueryParameter("hash", hash)
                .build()

            it.proceed(request.newBuilder().url(url).build())
        }

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .client(httpClient.build())
            .build()

        return retrofit.create<MarvelAPI>(MarvelAPI::class.java)
    }
}
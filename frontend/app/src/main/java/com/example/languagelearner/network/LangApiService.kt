package com.example.languagelearner.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL = "https://language-learner-0zma.onrender.com"


private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface LangApiService {
    @GET("quiz/")
    suspend fun getQuizzes(): List<Quiz>
}

object LangApi {
    val retrofitService : LangApiService by lazy {
        retrofit.create(LangApiService::class.java)
    }
}
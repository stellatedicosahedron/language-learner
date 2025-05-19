package com.example.languagelearner.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "https://language-learner-0zma.onrender.com"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface QuestionApiService {
    @GET("quiz/get_questions/{id}")
    suspend fun getQuestions(
        @Path("id") id: Int
    ): List<QuestionResponse>
}

object QuestionApi {
    val retrofitService : QuestionApiService by lazy {
        retrofit.create(QuestionApiService::class.java)
    }
}
package com.example.languagelearner.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.POST

private const val BASE_URL =
    "https://language-learner-0zma.onrender.com"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface UserApiService {
    @POST("api/create")
    suspend fun createUser(): String

    @POST("api/login")
    suspend fun loginUser(): String
}

// singleton design pattern is not encouraged! But it's what I found in the tutorial
object UserApi {
    val retrofitService : UserApiService by lazy {
        retrofit.create(UserApiService::class.java)
    }
}
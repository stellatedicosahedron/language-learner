package com.example.languagelearner.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonIgnoreUnknownKeys
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.POST

private const val BASE_URL =
    "https://language-learner-0zma.onrender.com"


private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface UserApiService {
    @POST("api/users/create/")
    suspend fun createUser(@Body user: User): DetailResponse

    @POST("api/users/login/")
    suspend fun loginUser(@Body user: User): DetailResponse
}

// singleton design pattern is not encouraged! But it's what I found in the tutorial
object UserApi {
    val retrofitService : UserApiService by lazy {
        retrofit.create(UserApiService::class.java)
    }
}
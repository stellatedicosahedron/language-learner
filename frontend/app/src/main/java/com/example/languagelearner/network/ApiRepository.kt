package com.example.languagelearner.network

import com.example.languagelearner.models.Quiz
import com.example.languagelearner.network.ApiClient.client
import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody

class ApiRepository {
    suspend fun getQuiz(id:Int): Quiz =
        client.get(ApiRoutes.BASE_URL+"/quiz/get/$id").body()

    suspend fun getAllQuizzes(): List<Quiz> =
        client.get(ApiRoutes.BASE_URL+"/quiz").body()

    suspend fun createNewQuiz(newQuiz:Quiz): Quiz =
        client.post(ApiRoutes.BASE_URL+"/quiz/add") {
            setBody(newQuiz)
        }.body()

    suspend fun updateQuiz(id:Int, quiz:Quiz): Quiz =
        client.put(ApiRoutes.BASE_URL+"/quiz/update/$id"){
            setBody(quiz)
        }.body()

    suspend fun deleteQuiz(id:Int): String =
        client.delete(ApiRoutes.BASE_URL+"delete/$id"){
        }.body()
}
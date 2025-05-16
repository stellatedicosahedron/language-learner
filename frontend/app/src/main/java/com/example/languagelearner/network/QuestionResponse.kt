package com.example.languagelearner.network

import kotlinx.serialization.Serializable

@Serializable
data class QuestionResponse(
    val id: Int,
    val question: String,
    val prompt: String,
    val answer: Int,
    val choices: String,
    val quiz: Int
)

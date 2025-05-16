package com.example.languagelearner.network

import kotlinx.serialization.Serializable

@Serializable
data class Question(
    val id: Int,
    val question: String,
    val prompt: String,
    val answer: Int,
    val choices: Map<String, String>,
    val quiz: Int
)

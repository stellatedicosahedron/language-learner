package com.example.languagelearner.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Quiz(
    @SerialName("name")
    val name: String,

    @SerialName("language")
    val language: String,

    @SerialName("level_requirement")
    val level_requirement: Int,

    @SerialName("level_reward")
    val level_reward: Int
)

package com.example.languagelearner.network

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class Quiz (
    val id: Int,
    val name: String,
    val language: String,
    @SerialName(value = "level_requirement")
    val levelRequirement: Int,
    @SerialName(value = "level_reward")
    val levelReward: Int
)

package com.example.languagelearner.network

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class UserResponse (
    val id: Int,
    val username: String,
)

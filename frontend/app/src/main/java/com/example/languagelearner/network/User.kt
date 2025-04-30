package com.example.languagelearner.network

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class User (
    val username: String,
    val password: String,
    @SerialName(value = "confirm_password")
    val confirmPassword: String
)

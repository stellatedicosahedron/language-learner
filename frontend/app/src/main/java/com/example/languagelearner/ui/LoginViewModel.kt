package com.example.languagelearner.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    // instead of storing these in the UI, we store these here
    // as before, these are state variables
    var usernameInput by mutableStateOf("")
        private set

    var passwordInput by mutableStateOf("")
        private set

    var confirmPasswordInput by mutableStateOf("")
        private set

    // since these variables exist here, we must update them here as well
    fun updateUsernameInput(input: String) {
        usernameInput = input
    }
    fun updatePasswordInput(input: String) {
        passwordInput = input
    }
    fun updateConfirmPasswordInput(input: String) {
        confirmPasswordInput = input
    }
}
package com.example.languagelearner.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.HttpException

class LoginViewModel : ViewModel() {
    var loginState = false

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

    fun clearFields() {
        updateUsernameInput("")
        updatePasswordInput("")
        updateConfirmPasswordInput("")
    }

    // retrofit stuff starts here
    private fun createUser() {
        viewModelScope.launch {

        }
    }

    private fun loginUser() {
        try{
            viewModelScope.launch {
                // retrofitService.loginUser()
                loginState = true
            }
        }
        catch (e: HttpException) {
            loginState = false // the failed login exception is prolly handled elsewhere
        }
    }
}
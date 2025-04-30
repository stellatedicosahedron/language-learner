package com.example.languagelearner.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.languagelearner.network.User
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import com.example.languagelearner.network.UserApi

class LoginViewModel : ViewModel() {
    var loginState = false
    var errorMessage by mutableStateOf("")

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
    fun createUser() {
        viewModelScope.launch {

        }
    }

    fun loginUser() {
        viewModelScope.launch {
            try{
                    UserApi.retrofitService
                        .loginUser(User(usernameInput, passwordInput, confirmPasswordInput))
                    // this is scuffed but I just want this to work for now
                    loginState = true

            } catch (e: HttpException) {
                loginState = false // login failed due to validation reasons
                errorMessage = e.message.toString()
            } catch (e: IOException) {
                loginState = false // login failed due to internet connection reasons
                errorMessage = "internet issue"
            }
        }
    }
}
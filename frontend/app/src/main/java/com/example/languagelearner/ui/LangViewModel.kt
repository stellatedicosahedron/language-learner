package com.example.languagelearner.ui

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.languagelearner.network.LangApi
import com.example.languagelearner.network.Quiz
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class LangViewModel : ViewModel() {
    var errorMessage by mutableStateOf("")

    var quizList by mutableStateOf<List<Quiz>>(listOf(Quiz(0, "Default Name", "na", 0, 0)))

    // state variables
    var languageSelection by mutableStateOf("")
        private set

    var shortLangSelection by mutableStateOf("")
        private set

    fun updateLanguageSelection(input: String) {
        languageSelection = input
    }

    fun updateShortLangSelection(input: String) {
        shortLangSelection = input
    }

    fun getQuizzes() {
        viewModelScope.launch {
            try {
                val temp: List<Quiz> = LangApi.retrofitService.getQuizzes()
                if (!temp.isEmpty()) {
                    quizList = temp
                }
            } catch (e: HttpException) {
                errorMessage = e.message.toString()
            } catch (e: IOException) {
                errorMessage = "internet issue"
            }
        }
    }
}
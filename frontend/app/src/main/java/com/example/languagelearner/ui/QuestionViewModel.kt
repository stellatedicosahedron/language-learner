package com.example.languagelearner.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class QuestionViewModel : ViewModel() {
    var currentSelection : Int? by mutableStateOf(null)

    // Change this later to list of questions
    // can then always find the current question by accessing the list at currIndex
    var questions : List<String>? = null

    var currIndex : Int = 0

    var currQuestion = questions?.get(currIndex)

    fun getQuestion() {
        viewModelScope.launch {
            try{
                // call the retrofit function to get all the questions from the current quiz
            } catch (e: HttpException) {
                // handle the exceptions
            } catch (e: IOException) {
                // handle the exceptions
            }
        }
    }
}
package com.example.languagelearner.ui

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.languagelearner.network.QuestionApi
import com.example.languagelearner.network.QuestionResponse
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class QuestionViewModel : ViewModel() {
    var currentSelection : Int? by mutableStateOf(null)

    var selectedQuiz : Int by mutableIntStateOf(1)

    // Change this later to list of questions
    // can then always find the current question by accessing the list at currIndex
    var questions : List<QuestionResponse>? = null

    var currIndex : Int = 0

    var currQuestion = questions?.get(currIndex)

    fun getQuestions() {
        viewModelScope.launch {
            try{
                // call the retrofit function to get all the questions from the current quiz
                questions = QuestionApi.retrofitService
                    .getQuestions(selectedQuiz)
            } catch (e: HttpException) {
                // handle the exceptions
            } catch (e: IOException) {
                // handle the exceptions
            } catch (e: IndexOutOfBoundsException) {
                // handle exception
            }
        }
    }
}
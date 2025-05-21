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
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import retrofit2.HttpException
import java.io.IOException

class QuestionViewModel : ViewModel() {
    var currentSelection : Int? by mutableStateOf(null)

    var selectedQuiz : Int by mutableIntStateOf(1)

    // Change this later to list of questions
    // can then always find the current question by accessing the list at currIndex
    var questions : List<QuestionResponse> = listOf(
        QuestionResponse(1, "", "", 1, "", 1)
    )

    private var currIndex : Int = 0

    var currQuestion = questions.get(currIndex)

    // var currChoices : Map<String, String> = convertMap(currQuestion.choices)
    var currChoices : Map<String, String> by mutableStateOf<Map<String,String>>(convertMap(currQuestion.choices))

    private fun convertMap (input: String): Map<String, String> {
        if(currQuestion.choices == "") {
            return mapOf("1" to "1", "2" to "2", "3" to "3", "4" to "4")
        }
        return Json.decodeFromString(input.replace("'", "\""))
    }

    fun getQuestions() {
        viewModelScope.launch {
            try{
                // call the retrofit function to get all the questions from the current quiz
                questions = QuestionApi.retrofitService
                    .getQuestions(selectedQuiz)
                currQuestion = questions.get(currIndex)
                currChoices = convertMap(currQuestion.choices)
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
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

/*
 *  A viewmodel mainly used for storing the states used when
 *  displaying questions. Stores the current quiz, list of
 *  questions, current question, and current choices.
 */
class QuestionViewModel : ViewModel() {
    var currentSelection : Int? by mutableStateOf(null)

    var selectedQuiz : Int by mutableIntStateOf(1)

    // Change this later to list of questions
    // can then always find the current question by accessing the list at currIndex
    var questions : List<QuestionResponse> = listOf(
        QuestionResponse(1, "", "", 1, "", 1)
    )

    var currIndex : Int = 0

    var maxQuestions : Int = questions.size

    var score = 0

    var answers : MutableList<Int?> = mutableListOf()

    var currQuestion = questions.get(currIndex)

    var short by mutableStateOf(false)

    val shortLength = 50
    // this dictates what length a question is considered to be "short"
    // due to how the choices are stored in a string, this just checks if the total length is a
    // certain number, equivalent to checking against the average length of the choice

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
                maxQuestions = questions.size
                short = computeShort()
            } catch (e: HttpException) {
                // handle the exceptions
            } catch (e: IOException) {
                // handle the exceptions
            } catch (e: IndexOutOfBoundsException) {
                // handle exception
            }
        }
    }

    fun nextQuestion() : Boolean {
        if (currIndex < maxQuestions - 1) {
            currIndex++
            currQuestion = questions.get(currIndex)
            currChoices = convertMap(currQuestion.choices)
            answers.add(currentSelection)
            short = computeShort()

            return true
        }
        else {
            answers.add(currentSelection)
            score = computeScore()
            return false
        }
    }

    fun resetQuiz() : Unit {
        currIndex = 0
        score = 0
        currentSelection = null
        answers = mutableListOf()
        currQuestion = questions.get(currIndex)
    }

    private fun computeScore() : Int {
        var score = 0
        for (i in 0..< maxQuestions) {
            if (answers[i]!! == questions[i].answer - 1) {
                score ++
            }
        }
        return score
    }

    private fun computeShort(): Boolean {
        if (currQuestion.choices.length < shortLength) {
            return true
        }
        else {
            return false
        }
    }
}
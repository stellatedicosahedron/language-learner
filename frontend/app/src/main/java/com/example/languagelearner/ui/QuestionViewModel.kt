package com.example.languagelearner.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

class QuestionViewModel {
    var currentSelection : Int? by mutableStateOf(null)

    fun updateCurrentSelection(selection: Int) {
        currentSelection = selection
    }
}
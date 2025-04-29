package com.example.languagelearner.ui

import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun QuizSelectScreen(
    modifier: Modifier = Modifier,
    onCreateButtonClick: () -> Unit,
) {
    Card () {
        Text(text = "Hello world")
    }
}
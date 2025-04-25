package com.example.languagelearner.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.languagelearner.network.ApiRepository
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun QuizSelectScreen(
    modifier: Modifier = Modifier,
    onCreateButtonClick: () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier,
    ) {
        val apiRepo = ApiRepository()
        val scope = rememberCoroutineScope()
        // getValue and setValue libraries are needed for line below (why??)
        var jsonResponse by remember { mutableStateOf("Placeholder") }

        Text(
            text = "Quiz Select Page"
        )
        Button(modifier = Modifier
            .align(alignment = Alignment.CenterHorizontally)
            .width(200.dp),
            onClick = {
                scope.launch {
                    jsonResponse = try {
                        apiRepo.getQuiz(1).toString()
                    } catch (e: io.ktor.serialization.JsonConvertException) {
                        "No Quizzes Found."
                    }
                }
            }) {
            Text("Press Button")
        }
        Button(
            onClick = onCreateButtonClick
        ) {
            Text( text = "Quiz Placeholder")
        }
        Text(text = jsonResponse)
        Text(text = (jsonResponse::class.simpleName).toString())
    }
}
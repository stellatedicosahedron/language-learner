package com.example.languagelearner.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.languagelearner.ui.theme.LanguageLearnerTheme

@Composable
fun ResultScreen (
    questionViewModel: QuestionViewModel,
    onReturnButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(horizontal = 40.dp)
            .fillMaxWidth()
            .fillMaxHeight()
    ) {

        Spacer(modifier = Modifier.height(100.dp))

        Text("Quiz Results:")

        Spacer(modifier = Modifier.height(25.dp))

        Text("Score: ${questionViewModel.score} / ${questionViewModel.maxQuestions}")

        Spacer(modifier = Modifier.height(25.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
        ) {
            LazyVerticalGrid (
                columns = GridCells.Fixed(1),
                modifier = Modifier
            ) {
                items(questionViewModel.maxQuestions) {
                        index ->
                    ResultItem(index, questionViewModel)
                }
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        )
        {
            Button(
                onClick = onReturnButtonClick
            ) {
                Text( text = "Back to quizzes")
            }
        }
    }
}

@Composable
fun ResultItem (
    index: Int,
    questionViewModel: QuestionViewModel,
    modifier: Modifier = Modifier
) {
    val color =
        if(questionViewModel.questions.get(index).answer - 1 == questionViewModel.answers.get(index))
            Color.hsv(126F, 0.35F, 0.70F)
        else
            Color.hsv(356F, 0.35F, 0.70F)

    val status =
        if(questionViewModel.questions.get(index).answer - 1 == questionViewModel.answers.get(index))
            "Correct"
        else
            "False"
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .size(50.dp)
            .padding(5.dp)
            .border(width = 1.dp, shape = RoundedCornerShape(10.dp), color = Color.White)
            .clip(shape = RoundedCornerShape(10.dp))
            .background(color)
    ) {
        Text(
            "Question ${index + 1}: ${status}",
            modifier = Modifier
                .align(Alignment.Center)
                .padding(8.dp)
        )
    }

}

@Preview
@Composable
fun ResultScreenPreview () {
    LanguageLearnerTheme (darkTheme = true) {
        ResultScreen(QuestionViewModel(), {})
    }

}
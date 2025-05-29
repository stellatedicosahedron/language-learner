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

/*
 *  A composable function for displaying the Question page
 *  in the application.
 *
 *  Displays Questions by showing a prompt, question, and
 *  4 choices, as well as a submit button.
 *
 *  Routes to Question display again when answering the question.
 */
@Composable
fun QuestionDisplay (
    questionViewModel: QuestionViewModel,
    onNextButtonClick: () ->  Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(horizontal = 40.dp)
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Spacer(modifier = Modifier.height(100.dp))
        Text(
            text = "Question ${questionViewModel.currIndex + 1}/${questionViewModel.maxQuestions}",
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            text = questionViewModel.currQuestion.question ,
            // replace this later with data from the viewmodel
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.height(25.dp))

        val short = questionViewModel.short

        if (short) {
            ShortAnswer(questionViewModel)
        }
        else{
            LongAnswer(questionViewModel)
        }
        Spacer(modifier = Modifier.height(25.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        )
        {
            Text("Selected Option: ${questionViewModel.currentSelection}")
            Button(
                onClick = onNextButtonClick
            ) {
                Text( text = "Next")
            }
        }
    }
}

/*
 *  A composable function for displaying the Long Answer
 *  variant of the Question page.
 *
 *  When any of the 4 options is too long to be displayed
 *  in the Short Answer variant, this page is used instead.
 */
@Composable
fun LongAnswer (
    questionViewModel: QuestionViewModel,
    modifier: Modifier = Modifier
) {
    var selectedOption by remember { mutableStateOf(0) }
    Column(

    ) {
        LazyVerticalGrid (
            columns = GridCells.Fixed(1),
            modifier = Modifier
        ) {
            items(4) {
                    index ->
                QuestionOption(
                    index,
                    {},
                    Alignment.CenterStart,
                    questionViewModel
                )
            }
        }
        LazyVerticalGrid (
            columns = GridCells.Fixed(2),
            modifier = Modifier
        ) {
        }
    }
}

/*
 *  A composable function for displaying the Short Answer
 *  variant of the Question page.
 *
 *  This page is used by default unless any of the 4 choices
 *  are too long to fit in this page format.
 */
@Composable
fun ShortAnswer(
    questionViewModel: QuestionViewModel,
    modifier: Modifier = Modifier
) {
    var selectedOption by remember { mutableStateOf(0) }
    Column(

    ) {
        LazyVerticalGrid (
            columns = GridCells.Fixed(2),
            modifier = Modifier
        ) {
            items(4) {
                index ->
                QuestionOption(
                    index,
                    {},
                    Alignment.Center,
                    questionViewModel
                )
            }
        }
        LazyVerticalGrid (
            columns = GridCells.Fixed(2),
            modifier = Modifier
        ) {
        }
    }

}

/*
 *  A composable function for displaying one of the
 *  four question options on the Question page.
 */
@Composable
fun QuestionOption (
    index: Int,
    onClick: () -> Unit,
    align: Alignment,
    questionViewModel: QuestionViewModel,
    modifier: Modifier = Modifier
) {
    val id : Int = index + 1
    if (questionViewModel.currentSelection == index) {
        Box(
            modifier = Modifier
                .selectable(
                    selected = false,
                    onClick = { questionViewModel.currentSelection = index }
                )
                .fillMaxWidth()
                .size(50.dp)
                .padding(5.dp)
                .border(width = 1.dp, shape = RoundedCornerShape(10.dp), color = Color.White)
                .clip(shape = RoundedCornerShape(10.dp))
                .background(Color.hsv(0F, 0.04F, 0.21F))
        ) {
            Text(
                // text = "Option ${index + 1}",
                text = questionViewModel.currChoices[id.toString()]!!,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(align)
                    .padding(8.dp)
            )
        }
    }
    else {
        Box(
            modifier = Modifier
                .selectable(
                    selected = false,
                    onClick = { questionViewModel.currentSelection = index }
                )
                .fillMaxWidth()
                .size(50.dp)
                .padding(5.dp)
                .clip(shape = RoundedCornerShape(10.dp))
                .border(width = 1.dp, shape = RoundedCornerShape(10.dp), color = Color.White)
        ) {
            Text(
                text = questionViewModel.currChoices[id.toString()]!!,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(align)
                    .padding(8.dp)

            )
        }
    }
}


@Preview
@Composable
fun PagePreview (

) {
    LanguageLearnerTheme(darkTheme = true) {
        QuestionDisplay(questionViewModel = QuestionViewModel(), {})
    }

}
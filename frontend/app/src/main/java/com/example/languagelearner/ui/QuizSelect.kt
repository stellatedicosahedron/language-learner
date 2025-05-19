package com.example.languagelearner.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.languagelearner.network.Quiz
import com.example.languagelearner.ui.theme.LanguageLearnerTheme

@Composable
fun QuizSelectScreen(
    modifier: Modifier = Modifier,
    onQuizSelectionClick: () -> Unit,
    langViewModel: LangViewModel,
    questionViewModel: QuestionViewModel
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(horizontal = 25.dp)
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState())
    ) {
        val langDict = mapOf(
            "jp" to "Japanese ",
            "kr" to "Korean ",
            "cn" to "Chinese ",
            "fr" to "French ",
            "na" to ""
        )
        Spacer(modifier = Modifier.height(70.dp))
        Text(
            text = "${langDict[langViewModel.shortLangSelection]}Lessons",
            fontSize = 40.sp,
            lineHeight = 42.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(30.dp))
        langViewModel.quizList.forEach {
            quiz -> QuizCard(
                quiz,
                onQuizSelectionClick
            )
        }
        Text(questionViewModel.questions.toString())
    }
}

@Composable
fun QuizCard(
    quiz: Quiz,
    onQuizSelectionClick: () -> Unit
) {
    OutlinedCard (
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth(),
        onClick = onQuizSelectionClick,
        shape = RoundedCornerShape(10.dp),
//        enabled = if (USERLEVEL >= REQ) true else false,
        enabled = true,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
        ),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
    ) {
        Box (
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ) {
            Text(
                text = "${quiz.name}",
                fontSize = 30.sp,
                lineHeight = 33.sp,
                textAlign = TextAlign.Center
            )
        }
        Row (
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .height(30.dp),
        ) {
            Text(text =
                "Requirement: ${quiz.levelRequirement}",
                fontSize = 20.sp,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 4.dp)
                    .wrapContentWidth(Alignment.Start)
            )
            Text(text = "Quiz Reward: ${quiz.levelReward}",
                fontSize = 20.sp,
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 4.dp)
                    .wrapContentWidth(Alignment.End)
            )
        }
    }
}

@Preview
@Composable
fun QuizSelectPreview(

) {
    LanguageLearnerTheme(darkTheme = true) { QuizSelectScreen (
        langViewModel = LangViewModel(),
        questionViewModel = QuestionViewModel(),
        onQuizSelectionClick = { }
    ) }

}
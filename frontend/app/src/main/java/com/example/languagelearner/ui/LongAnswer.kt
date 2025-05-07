package com.example.languagelearner.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.languagelearner.R
import com.example.languagelearner.ui.theme.LanguageLearnerTheme

@Composable
fun LongAnswer (
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
        Text(
            text = "Question 1/n",
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            text = "PLACEHOLDER TEXT FOR THE QUESTION" ,
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.height(25.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text( text = "option1" )
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text( text = "option2" )
        }
    }
}

@Preview
@Composable
fun LongAnswerPreview (

) {
    LongAnswer()
}
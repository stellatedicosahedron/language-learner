package com.example.languagelearner.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.languagelearner.ui.theme.LanguageLearnerTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onLoginButtonClick: () -> Unit, // the composable takes two lambdas as parameters
    onCreateButtonClick: () -> Unit, // which handle the navigation
) {
    LanguageLearnerTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Text(
                text = "Login Page CHANGE TO STRING RESOURCE"
            )
            Button(
                onClick = onLoginButtonClick
            ) {
                Text( text = "Login CHANGE TO STRING RESOURCE")
            }
            Button(
                onClick = onCreateButtonClick
            ) {
                Text( text = "Create Account CHANGE TO STRING RESOURCE")
            }
        }
    }

}
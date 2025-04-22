package com.example.languagelearner.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onLoginButtonClick: () -> Unit, // the composable takes two lambdas as parameters
    onCreateButtonClick: () -> Unit, // which handle the navigation
) {
    Surface (
        color = Color.hsv(0.20F, 0.07F, 0.18F)
    )
    {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
        ) {
            Text(
                text = "Login Page CHANGE TO STRING RESOURCE",
                color = Color.hsv(0.37F, 0.03F, 0.97F)
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
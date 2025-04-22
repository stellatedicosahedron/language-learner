package com.example.languagelearner.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CreateAccountScreen(
    modifier: Modifier = Modifier,
    onCreateButtonClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = "Create Account Page CHANGE TO STRING RESOURCE"
        )
        Button(
            onClick = onCreateButtonClick
        ) {
            Text( text = "Create Account CHANGE TO STRING RESOURCE")
        }
    }
}
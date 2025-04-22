package com.example.languagelearner.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun LanguageSelectScreen(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = "Language Select Page CHANGE TO STRING RESOURCE"
        )
        Button(
            onClick = { /*TODO*/ }
        ) {
            Text( text = "Japanese CHANGE TO STRING RESOURCE")
        }
    }
}
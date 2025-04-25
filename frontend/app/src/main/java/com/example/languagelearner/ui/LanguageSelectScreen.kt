package com.example.languagelearner.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.languagelearner.ui.theme.LanguageLearnerTheme

@Composable
fun LanguageSelectScreen(
    modifier: Modifier = Modifier,
    onLangSelectClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Text(
            text = "Language Select Page"
        )
        Button(
            onClick = onLangSelectClick
        ) {
            Text( text = "Select Quiz" )
        }
    }
}

@Preview
@Composable
fun Test(

) {
    LanguageLearnerTheme(darkTheme = true) { LanguageSelectScreen {  } }

}
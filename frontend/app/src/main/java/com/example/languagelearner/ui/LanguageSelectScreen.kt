package com.example.languagelearner.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.material3.OutlinedCard
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.languagelearner.R
import com.example.languagelearner.ui.theme.LanguageLearnerTheme

@Composable
fun LanguageSelectScreen(
    modifier: Modifier = Modifier,
    onLangSelectClick: () -> Unit
) {
    val langList = listOf("Japanese", "Korean", "Chinese", "French")
    val imageList = listOf(
        painterResource(id = R.drawable.japanese),
        painterResource(id = R.drawable.korean),
        painterResource(id = R.drawable.chinese),
        painterResource(id = R.drawable.french),
        )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(horizontal = 25.dp)
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Spacer(modifier = Modifier.height(70.dp))
        Text(
            text = "Select a Language to Learn",
            fontSize = 40.sp,
            lineHeight = 42.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(30.dp))
        LazyVerticalGrid (
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(0.dp),
            modifier = Modifier
        ) {
            items(langList.size) {
                val item = langList[it]
                val painter = imageList[it]
                ImageCard(item, painter, item, onLangSelectClick, Modifier)
            }
        }
    }
}

// creates an image card
// arguments are an image, description, title, and modifier
@Composable
fun ImageCard(
    title: String,
    painter: Painter,
    contentDescription: String,
    onLangSelectClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card (
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        onClick = onLangSelectClick,
        modifier = modifier
            .fillMaxWidth()
            .padding(7.dp, 7.dp)
    ) {
        Box (
            modifier = Modifier.height(200.dp)
        ) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            Box (
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 320f
                        )
                    )
            )
            Box (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Text(
                    title,
                    style = TextStyle(color = Color.White, fontSize = 16.sp)
                )
            }
        }
    }
}

@Preview
@Composable
fun Test(

) {
    LanguageLearnerTheme(darkTheme = true) { LanguageSelectScreen {  } }

}
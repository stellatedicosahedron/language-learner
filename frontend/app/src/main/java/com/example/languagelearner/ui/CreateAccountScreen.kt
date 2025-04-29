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
import com.example.languagelearner.R
import com.example.languagelearner.ui.theme.LanguageLearnerTheme

@Composable
fun CreateAccountScreen(
    modifier: Modifier = Modifier,
    onCreateButtonClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(horizontal = 40.dp)
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Spacer(modifier = Modifier.height(150.dp))
        Text(
            text = stringResource(R.string.create_account),
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.height(20.dp))
        CreateAccountField(modifier)
        Spacer(modifier = Modifier.height(20.dp))
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            OutlinedButton(
                onClick = onCreateButtonClick
            ) {
                Text (text = stringResource(R.string.create_account) )
            }
        }


    }
}

@Composable
fun CreateAccountField(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
    ) {
        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var confirmPassword by remember { mutableStateOf("") }
        Text(
            text = stringResource(R.string.username),
            modifier = Modifier.align(Alignment.Start)
        )
        TextField(
            value = username,
            onValueChange = { username = it },
            modifier = modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(R.string.password),
            modifier = Modifier.align(Alignment.Start)
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(R.string.confirm_password),
            modifier = Modifier.align(Alignment.Start)
        )
        TextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = modifier.fillMaxWidth(),
        )
    }
}

// going to need to display a toast maybe if some fields are wrong

@Preview
@Composable
fun CreateScreenPreview() {
    LanguageLearnerTheme(darkTheme = true) {
        CreateAccountScreen(
            modifier = Modifier,
            onCreateButtonClick = {}
        )
    }
}
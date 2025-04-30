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
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.languagelearner.ui.theme.LanguageLearnerTheme
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.languagelearner.R

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    loginViewModel: LoginViewModel,
    onLoginButtonClick: () -> Unit, // the composable takes two lambdas as parameters
    onCreateButtonClick: () -> Unit, // which handle the navigation
) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(horizontal = 40.dp)
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Spacer(modifier = Modifier.height(200.dp))
            Text(
                text = "LLA LOGO",
                fontSize = 50.sp
            )
            Spacer(modifier = Modifier.height(20.dp))
            // here
            LoginField(
                modifier = modifier,
                usernameInput = loginViewModel.usernameInput,
                passwordInput = loginViewModel.passwordInput,
                onUsernameChange = { loginViewModel.updateUsernameInput(it) },
                onPasswordChange = { loginViewModel.updatePasswordInput(it) }
            )
            // to here
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
                Button(
                    onClick = onLoginButtonClick
                ) {
                    Text( text = stringResource(R.string.login))
                }
            }


        }


}

// Make one big composable for all the login fields
@Composable
fun UsernameField(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { text = it },
        modifier = modifier.fillMaxWidth(),
    )
}

@Composable
fun PasswordField(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { text = it },
        modifier = modifier.fillMaxWidth(),
    )
}

@Composable
fun LoginField(
    modifier: Modifier = Modifier,
    usernameInput: String,
    passwordInput: String,
    onUsernameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit
) {
    Column(
        modifier = Modifier
    ) {
        Text(
            text = stringResource(R.string.username),
            modifier = Modifier.align(Alignment.Start)
        )
        // Username field
        TextField(
            value = usernameInput,
            onValueChange = onUsernameChange,
            modifier = modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(R.string.password),
            modifier = Modifier.align(Alignment.Start)
        )
        // Password field
        TextField(
            value = passwordInput,
            onValueChange = onPasswordChange,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = modifier.fillMaxWidth(),
        )
    }

}

@Preview
@Composable
fun LoginScreenPreview(){
    LanguageLearnerTheme(darkTheme = true) {
        LoginScreen(
            modifier = Modifier,
            loginViewModel = LoginViewModel(),
            onLoginButtonClick = {},
            onCreateButtonClick = {}
            )
    }
}
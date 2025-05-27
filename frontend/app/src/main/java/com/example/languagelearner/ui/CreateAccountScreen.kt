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
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.languagelearner.R
import com.example.languagelearner.ui.theme.LanguageLearnerTheme
import io.ktor.utils.io.core.Input

/*
 *  A composable function for displaying the Account Creation page
 *  in the application.
 *
 *  Contains username, password, and confirm password fields.
 *
 *  Routes to the Login page upon successfully creating an account.
 */
@Composable
fun CreateAccountScreen(
    modifier: Modifier = Modifier,
    loginViewModel: LoginViewModel,
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
        CreateAccountField(
            modifier,
            usernameInput = loginViewModel.usernameInput,
            passwordInput = loginViewModel.passwordInput,
            confirmPasswordInput = loginViewModel.confirmPasswordInput,
            onUsernameChange = { loginViewModel.updateUsernameInput(it) },
            onPasswordChange = { loginViewModel.updatePasswordInput(it) },
            onConfirmPasswordChange = { loginViewModel.updateConfirmPasswordInput(it) }
        )
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
        Spacer(modifier = Modifier.height(20.dp))
        Text( text = loginViewModel.errorMessage )

    }
}

@Composable
fun CreateAccountField(
    modifier: Modifier = Modifier,
    usernameInput: String,
    passwordInput: String,
    confirmPasswordInput: String,
    onUsernameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onConfirmPasswordChange: (String) -> Unit
) {
    Column(
        modifier = Modifier
    ) {
        Text(
            text = stringResource(R.string.username),
            modifier = Modifier.align(Alignment.Start)
        )
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
        TextField(
            value = passwordInput,
            onValueChange = onPasswordChange,
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
            value = confirmPasswordInput,
            onValueChange = onConfirmPasswordChange,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = modifier.fillMaxWidth(),
        )
    }
}

@Preview
@Composable
fun CreateScreenPreview() {
    LanguageLearnerTheme(darkTheme = true) {
        CreateAccountScreen(
            modifier = Modifier,
            loginViewModel = LoginViewModel(),
            onCreateButtonClick = {}
        )
    }
}
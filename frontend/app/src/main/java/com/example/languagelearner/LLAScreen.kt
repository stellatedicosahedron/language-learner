package com.example.languagelearner

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.languagelearner.ui.LoginScreen
import com.example.languagelearner.ui.CreateAccountScreen
import com.example.languagelearner.ui.LanguageSelectScreen

// This class just serves as a list of names for each route in the app
enum class LLAScreen() {
    Login,
    CreateAccount,
    LangSelect,
    QuizSelect,
    ShortAnswer,
    LongAnswer,
    Result,
    Settings
}

@Preview
@Composable
fun MainDisplay(
    navController: NavHostController = rememberNavController()
) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = LLAScreen.Login.name, // the default page on startup
            modifier = Modifier.padding(innerPadding)
        ) {
            // in this function body, each call to a composable function dictates behaviour
            // at a different screen
            composable(route = LLAScreen.Login.name) {
                LoginScreen(
                    onLoginButtonClick = {
                        navController.navigate(LLAScreen.LangSelect.name)
                        // login validation and whatnot
                    },
                    onCreateButtonClick = {
                        navController.navigate(LLAScreen.CreateAccount.name)
                    }
                )
            }
            composable(route = LLAScreen.CreateAccount.name) {
                CreateAccountScreen(
                    onCreateButtonClick = {
                        navController.popBackStack(LLAScreen.Login.name, false)
                    }
                )
            }
            composable(route = LLAScreen.LangSelect.name) {
                LanguageSelectScreen(

                )
            }
        }
    }
}

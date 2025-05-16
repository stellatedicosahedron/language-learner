package com.example.languagelearner

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.languagelearner.ui.LoginScreen
import com.example.languagelearner.ui.CreateAccountScreen
import com.example.languagelearner.ui.LanguageSelectScreen
import com.example.languagelearner.ui.LoginViewModel
import com.example.languagelearner.ui.QuestionDisplay
import com.example.languagelearner.ui.QuestionViewModel
import com.example.languagelearner.ui.theme.LanguageLearnerTheme
import com.example.languagelearner.ui.QuizSelectScreen

// This class just serves as a list of names for each route in the app
enum class LLAScreen() {
    Login,
    CreateAccount,
    LangSelect,
    QuizSelect,
    QuestionScreen,
    Result,
    Settings
}

@Composable
fun MainDisplay(
    navController: NavHostController = rememberNavController(),
    loginViewModel: LoginViewModel = LoginViewModel(),
    questionViewModel: QuestionViewModel = QuestionViewModel(),
) {
    LanguageLearnerTheme(darkTheme = true) {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

            NavHost(
                navController = navController,
                startDestination = LLAScreen.Login.name, // the default page on startup
                modifier = Modifier.padding(innerPadding)
            ) {
                // figure out how to route this later
                composable(route = LLAScreen.QuestionScreen.name) {
                    QuestionDisplay(
                        questionViewModel = questionViewModel
                    )
                }

                // in this function body, each call to a composable function dictates behaviour
                // at a different screen
                composable(route = LLAScreen.Login.name) {
                    loginViewModel.clearFields()
                    LoginScreen(
                        loginViewModel = loginViewModel,
                        onLoginButtonClick = {
                            loginViewModel.clearErrorMessage()
                            loginViewModel.loginUser()
                            if (loginViewModel.loginState) {
                                navController.navigate(LLAScreen.LangSelect.name)
                            }
                        },
                        onCreateButtonClick = {
                            loginViewModel.createState = false
                            navController.navigate(LLAScreen.CreateAccount.name)
                        }
                    )
                }
                composable(route = LLAScreen.CreateAccount.name) {
                    loginViewModel.clearFields()
                    CreateAccountScreen(
                        loginViewModel = loginViewModel,
                        onCreateButtonClick = {
                            loginViewModel.clearErrorMessage()
                            loginViewModel.createUser()
                            if (loginViewModel.createState) {
                                loginViewModel.clearFields()
                                // if account creation successful, clear the fields and
                                // return to the login page
                                navController.popBackStack(LLAScreen.Login.name, false)
                            }
                        }
                    )
                }
                composable(route = LLAScreen.LangSelect.name) {
                    LanguageSelectScreen(
                        onLangSelectClick = {
                            navController.navigate(LLAScreen.QuizSelect.name)
                        }
                    )
                }
                composable(route = LLAScreen.QuizSelect.name) {
                    QuizSelectScreen {

                    }
                }
            }
        }
    }

}

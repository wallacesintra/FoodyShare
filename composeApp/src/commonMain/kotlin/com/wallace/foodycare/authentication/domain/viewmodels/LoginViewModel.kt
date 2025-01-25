package com.wallace.foodycare.authentication.domain.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.wallace.foodycare.authentication.domain.events.LoginEvent
import com.wallace.foodycare.authentication.domain.states.LoginFormState
import com.wallace.foodycare.core.domain.usecases.ValidateEmail
import com.wallace.foodycare.core.domain.usecases.ValidateString
import com.wallace.foodycare.core.presentation.navigation.MapScreen
import com.wallace.foodycare.navController

class LoginViewModel(
): ViewModel() {

    var loginFormState by mutableStateOf(LoginFormState())
    private val validateString = ValidateString()
    private val validateEmail = ValidateEmail()

    fun onLoginEvent(event: LoginEvent){
        when(event){
            is LoginEvent.EmailChange -> {
                loginFormState = loginFormState.copy(
                    email = event.email
                )
            }
            is LoginEvent.PasswordChange -> {
                loginFormState = loginFormState.copy(
                    password = event.password
                )
            }
            LoginEvent.Login -> logIn()

        }
    }

    private fun logIn() {
        val emailResult = validateEmail.execute(email = loginFormState.email)
        val passwordResult = validateString.execute(text = loginFormState.password)

        val hasError = listOf(
            emailResult,
            passwordResult
        ).any { !it.successful }

        if (hasError){
            loginFormState = loginFormState.copy(
                emailError = emailResult.errorMessage,
                passwordError = passwordResult.errorMessage
            )

            return
        }

        loginFormState = loginFormState.copy(
            emailError = emailResult.errorMessage,
            passwordError = passwordResult.errorMessage
        )

        navController.navigate("MapScreen")



    }

}
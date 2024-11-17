package com.wallace.foodycare.authentication.domain.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.wallace.foodycare.authentication.domain.events.LoginEvent
import com.wallace.foodycare.authentication.domain.states.LoginFormState
import com.wallace.foodycare.core.domain.usecases.ValidateString

class LoginViewModel(
): ViewModel() {

    var loginFormState by mutableStateOf(LoginFormState())
    private val validateString = ValidateString()

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
        val emailResult = validateString.execute(text = loginFormState.email)
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



    }

}
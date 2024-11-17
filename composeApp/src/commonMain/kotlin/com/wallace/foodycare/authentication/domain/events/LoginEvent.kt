package com.wallace.foodycare.authentication.domain.events

sealed class LoginEvent {
    data class EmailChange(val email: String): LoginEvent()
    data class PasswordChange(val password: String): LoginEvent()

    data object Login: LoginEvent()
}
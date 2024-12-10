package com.wallace.foodycare.core.domain.usecases

class ValidateEmail {
    fun execute(email: String): ValidationResult{
        if (email.isBlank()){
            return ValidationResult(
                successful = false,
                errorMessage = "Please enter email"
            )
        }

        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        if (!email.matches(emailPattern.toRegex())){
            return ValidationResult(
                successful = false,
                errorMessage = "Invalid email format"
            )
        }

        return ValidationResult(
            successful = true
        )
    }
}
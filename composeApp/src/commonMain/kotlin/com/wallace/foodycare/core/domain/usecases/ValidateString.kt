package com.wallace.foodycare.core.domain.usecases

class ValidateString {
    fun execute(text: String?): ValidationResult {
        if (text.isNullOrBlank()){
            return ValidationResult(
                successful = false,
                errorMessage = "Please enter"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}
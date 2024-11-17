package com.wallace.foodycare.core.domain.usecases

import com.wallace.foodycare.authentication.domain.usecases.ValidateResult

class ValidateString {
    fun execute(text: String?): ValidateResult {
        if (text.isNullOrBlank()){
            return ValidateResult(
                successful = false,
                errorMessage = "Please enter"
            )
        }
        return ValidateResult(
            successful = true
        )
    }
}
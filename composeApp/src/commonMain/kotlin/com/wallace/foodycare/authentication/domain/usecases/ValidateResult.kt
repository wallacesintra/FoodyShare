package com.wallace.foodycare.authentication.domain.usecases

data class ValidateResult(
    val successful: Boolean,
    val errorMessage: String? = null
)

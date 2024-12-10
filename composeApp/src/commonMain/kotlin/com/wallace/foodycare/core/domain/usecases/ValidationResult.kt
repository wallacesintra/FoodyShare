package com.wallace.foodycare.core.domain.usecases

data class ValidationResult(
    val successful: Boolean,
    val errorMessage: String? = null
)

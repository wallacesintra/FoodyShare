package com.wallace.foodycare.core.di

import com.wallace.foodycare.authentication.domain.viewmodels.LoginViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

fun commonModule(): Module = module {

    viewModel<LoginViewModel> {
        LoginViewModel()
    }
}
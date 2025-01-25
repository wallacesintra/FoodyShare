package di

import com.wallace.foodycare.authentication.domain.viewmodels.LoginViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

fun testModule() = module {
    viewModel<LoginViewModel> {
        LoginViewModel()
    }
}
package com.wallace.foodycare

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.wallace.foodycare.core.di.KoinInit
import com.wallace.foodycare.core.di.commonModule
import com.wallace.foodycare.core.di.platformModule

fun main() {
    KoinInit().init{
        modules(
            listOf(
                platformModule(),
                commonModule()
            )
        )
    }
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "FoodyCare",
        ) {
            App()
        }
    }
}

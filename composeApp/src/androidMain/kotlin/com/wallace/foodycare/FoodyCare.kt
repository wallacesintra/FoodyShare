package com.wallace.foodycare

import android.app.Application
import com.wallace.foodycare.core.di.KoinInit
import com.wallace.foodycare.core.di.commonModule
import com.wallace.foodycare.core.di.platformModule
import org.koin.android.ext.koin.androidContext

class FoodyCare: Application() {
    override fun onCreate() {
        super.onCreate()

        KoinInit().init{
            androidContext(androidContext = this@FoodyCare)

            modules(
                listOf(
                    platformModule(),
                    commonModule()
                )
            )
        }
    }
}
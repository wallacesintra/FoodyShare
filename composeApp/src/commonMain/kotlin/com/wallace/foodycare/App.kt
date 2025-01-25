package com.wallace.foodycare

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.wallace.foodycare.authentication.presentation.LoginPage
import com.wallace.foodycare.core.presentation.navigation.FoodyCareNavHost
import org.jetbrains.compose.ui.tooling.preview.Preview

import org.koin.compose.KoinContext

lateinit var navController: NavHostController

@Composable
@Preview
fun App() {

     navController = rememberNavController()

    MaterialTheme {
        KoinContext {
               Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                   FoodyCareNavHost(navController = navController)
            }
        }
    }
}
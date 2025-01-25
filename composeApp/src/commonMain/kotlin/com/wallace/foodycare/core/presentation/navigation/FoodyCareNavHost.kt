package com.wallace.foodycare.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.wallace.foodycare.authentication.presentation.LoginPage
import com.wallace.foodycare.map.MapView

@Composable
fun FoodyCareNavHost(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = "LoginScreen"
    ){
        composable("LoginScreen") { LoginPage() }
        composable("MapScreen") { MapView(modifier = Modifier)  }

    }

}
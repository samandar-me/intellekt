package com.sdk.tafakkur.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sdk.tafakkur.ui.auth.login.LoginScreen
import com.sdk.tafakkur.ui.auth.register.RegisterScreen
import com.sdk.tafakkur.util.Graph

@Composable
fun RootNavigation(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        route = Graph.ROOT,
        startDestination = "login"
    ) {
        composable("login") {
            LoginScreen(navController = navHostController)
        }
        composable("register") {
            RegisterScreen(navController = navHostController)
        }
    }
}
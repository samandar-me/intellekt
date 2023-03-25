package com.sdk.tafakkur.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sdk.tafakkur.ui.main.MainScreen
import com.sdk.tafakkur.util.Graph

@Composable
fun RootNavigation(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        route = Graph.ROOT,
        startDestination = Graph.SPLASH
    ) {

        splashNavGraph(navController = navHostController)
//        authNavGraph(navHostController)
        composable(route = Graph.MAIN) {
            MainScreen()
        }
    }
}
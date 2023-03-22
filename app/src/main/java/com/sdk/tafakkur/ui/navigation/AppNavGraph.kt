package com.sdk.tafakkur.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.sdk.tafakkur.ui.auth.login.LoginScreen
import com.sdk.tafakkur.ui.auth.register.RegisterScreen
import com.sdk.tafakkur.ui.game.GameScreen
import com.sdk.tafakkur.ui.main.home.HomeScreen
import com.sdk.tafakkur.ui.main.settings.SettingsScreen
import com.sdk.tafakkur.ui.main.stats.StatsScreen
import com.sdk.tafakkur.util.Graph

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTH,
        startDestination = "login"
    ) {
        composable("login") {
            LoginScreen(navController = navController)
        }
        composable("register") {
            RegisterScreen(navController = navController)
        }
    }
}

@Composable
fun MainNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.MAIN,
        startDestination = BottomBarScreen.HomeScreen.route
    ) {
        composable(route = BottomBarScreen.HomeScreen.route) {
            HomeScreen()
        }
        composable(route = BottomBarScreen.Statistics.route) {
            StatsScreen()
        }
        composable(route = BottomBarScreen.Settings.route) {
            SettingsScreen()
        }
    }
}

fun NavGraphBuilder.detailsScreen(navHostController: NavHostController) {
    navigation(
        route = Graph.DETAIL,
        startDestination = "game"
    ) {
        composable(
            route = "game"
        ) {
            GameScreen()
        }
    }
}
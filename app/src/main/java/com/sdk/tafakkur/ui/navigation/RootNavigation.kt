package com.sdk.tafakkur.ui.navigation

import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sdk.tafakkur.ui.auth.login.LoginScreen
import com.sdk.tafakkur.ui.auth.register.RegisterScreen
import com.sdk.tafakkur.ui.main.MainScreen
import com.sdk.tafakkur.util.Graph
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun RootNavigation(navHostController: NavHostController, isAuthed: Boolean) {
    var graph by remember {
        mutableStateOf(Graph.MAIN)
    }
    if (!isAuthed) {
        graph = Graph.AUTH
    }
    NavHost(
        navController = navHostController,
        route = Graph.ROOT,
        startDestination = graph
    ) {
        composable(route = Graph.MAIN) {
            MainScreen()
        }
        authNavGraph(navController = navHostController)
    }
}
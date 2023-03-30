package com.sdk.tafakkur.ui.main

import android.util.Log
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.sdk.tafakkur.ui.main.settings.SettingsViewModel
import com.sdk.tafakkur.util.Graph
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navHostController: NavHostController
) {
    val viewModel: SettingsViewModel = hiltViewModel()
    val isAuthed by viewModel.isAuthed.collectAsState()
    LaunchedEffect(key1 = true) {
        delay(100L)
        navHostController.navigate(if (isAuthed) Graph.MAIN else "login") {
            popUpTo(Graph.SPLASH) {
                inclusive = true
            }
        }
    }
}
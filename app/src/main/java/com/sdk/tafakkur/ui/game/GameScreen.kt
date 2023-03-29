package com.sdk.tafakkur.ui.game

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreen(navHostController: NavHostController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            SmallTopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Transparent),
                title = {

                },
                navigationIcon = {
                    IconButton(onClick = { navHostController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {

        }
    }
}
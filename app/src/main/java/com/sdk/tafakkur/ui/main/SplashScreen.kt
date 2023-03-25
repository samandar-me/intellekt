package com.sdk.tafakkur.ui.main

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import com.sdk.tafakkur.R
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sdk.tafakkur.ui.theme.RobotBold
import com.sdk.tafakkur.ui.theme.TafakkurTheme
import com.sdk.tafakkur.util.Graph
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SplashScreen(
    navHostController: NavHostController,
) {
    val isAuthed by remember {
        mutableStateOf(true)
    }
    val route by remember {
        mutableStateOf(if (isAuthed) Graph.MAIN else "login")
    }
    var startAnimation by remember {
        mutableStateOf(false)
    }
    val alphaAnim by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(1500)
    )
    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(1500L)
        navHostController.navigate(route) {
            popUpTo(Graph.SPLASH) {
                inclusive = true
            }
        }
    }
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logical_think),
                contentDescription = "app_logo",
                modifier = Modifier
                    .size(150.dp)
                    .alpha(alphaAnim)
            )
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = stringResource(id = R.string.app_name),
                fontSize = 22.sp,
                fontFamily = RobotBold
            )
        }
    }
}
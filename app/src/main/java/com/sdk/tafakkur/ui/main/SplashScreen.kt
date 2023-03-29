package com.sdk.tafakkur.ui.main

import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.sdk.tafakkur.ui.main.settings.SettingsViewModel
import com.sdk.tafakkur.util.Graph

@Composable
fun SplashScreen(
    navHostController: NavHostController,
) {
    val viewModel: SettingsViewModel = hiltViewModel()
    val isAuthed by viewModel.isAuthed.collectAsState()
    var startAnimation by remember {
        mutableStateOf(false)
    }
//    val alphaAnim by animateFloatAsState(
//        targetValue = if (startAnimation) 1f else 0f,
//        animationSpec = tween(1500)
//    )
    LaunchedEffect(key1 = true) {
//        startAnimation = true
//        delay(1500L)
        navHostController.navigate(if (true) Graph.MAIN else "login") {
            popUpTo(Graph.SPLASH) {
                inclusive = true
            }
        }
    }
//    Scaffold { paddingValues ->
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(paddingValues),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            Image(
//                painter = painterResource(id = R.drawable.logical_think),
//                contentDescription = "app_logo",
//                modifier = Modifier
//                    .size(150.dp)
//               //     .alpha(alphaAnim)
//            )
//            Spacer(modifier = Modifier.height(50.dp))
//            Text(
//                text = stringResource(id = R.string.app_name),
//                fontSize = 22.sp,
//                fontFamily = RobotBold
//            )
//        }
//    }
}
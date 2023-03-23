package com.sdk.tafakkur.ui.main.home

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sdk.tafakkur.R
import com.sdk.tafakkur.ui.components.CircleImage
import com.sdk.tafakkur.ui.theme.Blue
import com.sdk.tafakkur.ui.theme.LightBlue
import com.sdk.tafakkur.ui.theme.RobotBold
import com.sdk.tafakkur.util.Graph

@Composable
fun HomeScreen(navHostController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    listOf(
                        Color.LightGray.copy(alpha = .35f),
                        LightBlue,
                    )
                )
            )
            .padding(8.dp)
    ) {
        SmallTopAppBar(
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Transparent),
            title = {
                Text(
                    text = "${stringResource(id = R.string.hello)}, Samandar",
                    fontFamily = RobotBold
                )
            },
            actions = {
                CircleImage(url = "https://firebasestorage.googleapis.com/v0/b/tafakkur-32f28.appspot.com/o/images%2Fistockphoto-1300845620-612x612.jpg?alt=media&token=e676c8a3-3be6-4f7c-a9a2-501e9cfaf522") {
                    navHostController.navigate(Graph.PROFILE)
                }
            }
        )
    }
}
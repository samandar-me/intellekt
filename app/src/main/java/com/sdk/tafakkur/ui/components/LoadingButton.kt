package com.sdk.tafakkur.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sdk.tafakkur.ui.theme.Blue
import com.sdk.tafakkur.ui.theme.RobotBold

@Composable
fun LoadingButton(
    isLoading: Boolean,
    textId: Int,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp),
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(
            visible = !isLoading,
            exit = fadeOut(),
            enter = fadeIn()
        ) {
            ElevatedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(containerColor = Blue)
            ) {
                Text(
                    text = stringResource(id = textId),
                    color = Color.White,
                    fontSize = 15.sp,
                    fontFamily = RobotBold
                )
            }
        }
        AnimatedVisibility(
            visible = isLoading,
            exit = fadeOut(),
            enter = fadeIn()
        ) {
            LoadingBar()
        }
    }
}
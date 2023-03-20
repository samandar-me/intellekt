package com.sdk.tafakkur.ui.auth.register

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sdk.tafakkur.ui.theme.Blue

@Composable
fun LoadingBar() {
    CircularProgressIndicator(
        color = Blue,
        modifier = Modifier.size(34.dp),
        strokeWidth = 3.dp
    )
}
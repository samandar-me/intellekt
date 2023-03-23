package com.sdk.tafakkur.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.rememberCoilPainter
import com.sdk.tafakkur.ui.theme.LightBlue

@Composable
fun CircleImage(
    url: String,
    onClick: () -> Unit
) {
    val coil = rememberCoilPainter(request = url)
    Box(
        modifier = Modifier
            .size(45.dp)
            .clip(CircleShape)
            .border(1.dp, LightBlue, CircleShape)
            .clickable {
                onClick()
            }
    ) {
        Image(painter = coil, contentDescription = "image", modifier = Modifier.fillMaxSize())
    }
}
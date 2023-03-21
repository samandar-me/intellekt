package com.sdk.tafakkur.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sdk.tafakkur.ui.theme.*

@Composable
fun SuccessMessageBar(
    text: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(LightBlue),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(10.dp))
        Icon(imageVector = Icons.Default.Check, contentDescription = "check", tint = DarkBlue)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text, fontSize = 13.sp, fontFamily = RobotBold, color = DarkBlue)
    }
}

@Composable
fun ErrorMessageBar(
    text: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Error90),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(10.dp))
        Icon(imageVector = Icons.Default.Warning, contentDescription = "warning", tint = DarkRed)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text, fontSize = 13.sp, fontFamily = RobotBold, color = DarkRed)
    }
}
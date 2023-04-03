package com.sdk.tafakkur.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sdk.tafakkur.ui.theme.Blue

@Composable
fun OptionItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    color: Color?,
    text: String,
    isEnabled: Boolean
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(55.dp)
            .background(color ?: MaterialTheme.colorScheme.surfaceVariant)
            .clip(RoundedCornerShape(5.dp))
            .border(1.dp, Blue, RoundedCornerShape(5.dp))
            .clickable(enabled = isEnabled) { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(text = text, textAlign = TextAlign.Center)
    }
}
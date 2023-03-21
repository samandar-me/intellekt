package com.sdk.tafakkur.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sdk.tafakkur.ui.theme.Blue

@Composable
fun AppTextField(
    text: String,
    hint: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = text,
        onValueChange = onValueChange,
        label = { Text(text = hint) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Blue,
            focusedBorderColor = Blue,
            focusedLabelColor = Blue,
            cursorColor = Blue
        ),
        maxLines = 1,
        singleLine = true,
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp)
    )
}
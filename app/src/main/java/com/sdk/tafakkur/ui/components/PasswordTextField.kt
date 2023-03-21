package com.sdk.tafakkur.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.sdk.tafakkur.R
import com.sdk.tafakkur.ui.theme.Blue

@Composable
fun PasswordTextField(
    text: String,
    hint: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    var passwordVisibility by remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        value = text,
        onValueChange = onValueChange,
        label = { Text(text = hint) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Blue,
            focusedBorderColor = Blue,
            focusedLabelColor = Blue,
            cursorColor = Blue,
            focusedTrailingIconColor = Blue
        ),
        maxLines = 1,
        singleLine = true,
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = {
                passwordVisibility = !passwordVisibility
            }) {
                Icon(
                    painter = painterResource(id = if (passwordVisibility) R.drawable.baseline_visibility_24 else R.drawable.baseline_visibility_off_24),
                    contentDescription = "Password",
                )
            }
        }
    )
}
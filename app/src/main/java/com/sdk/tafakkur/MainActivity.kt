package com.sdk.tafakkur

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.sdk.tafakkur.ui.navigation.RootNavigation
import com.sdk.tafakkur.ui.theme.TafakkurTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            delay(2000L)
            window.setBackgroundDrawableResource(android.R.color.transparent)
        }
        setContent {
            TafakkurTheme(
                darkTheme = isSystemInDarkTheme()
            ) {
                RootNavigation(
                    navHostController = rememberNavController()
                )
            }
        }
    }
}

@Composable
fun ColorsTest() {
    val colorList = listOf(
        MaterialTheme.colorScheme.primary,
        MaterialTheme.colorScheme.onPrimary,
        MaterialTheme.colorScheme.primaryContainer,
        MaterialTheme.colorScheme.onPrimaryContainer,
        MaterialTheme.colorScheme.inversePrimary,
        MaterialTheme.colorScheme.secondary,
        MaterialTheme.colorScheme.onSecondary,
        MaterialTheme.colorScheme.secondaryContainer,
        MaterialTheme.colorScheme.secondaryContainer,
        MaterialTheme.colorScheme.onSecondaryContainer,
        MaterialTheme.colorScheme.tertiary,
        MaterialTheme.colorScheme.onTertiary,
        MaterialTheme.colorScheme.tertiaryContainer,
        MaterialTheme.colorScheme.onTertiaryContainer,
        MaterialTheme.colorScheme.background,
        MaterialTheme.colorScheme.onBackground,
        MaterialTheme.colorScheme.surface,
        MaterialTheme.colorScheme.onSurface,
        MaterialTheme.colorScheme.surfaceVariant,
        MaterialTheme.colorScheme.onSurfaceVariant,
        MaterialTheme.colorScheme.surfaceTint,
        MaterialTheme.colorScheme.inverseSurface,
        MaterialTheme.colorScheme.inverseOnSurface,
        MaterialTheme.colorScheme.error,
        MaterialTheme.colorScheme.onError,
        MaterialTheme.colorScheme.errorContainer,
        MaterialTheme.colorScheme.onErrorContainer,
        MaterialTheme.colorScheme.outline
    )
    LazyColumn {
        itemsIndexed(colorList) { index, item ->  
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
                .background(item))
            Text(text = index.toString(), fontSize = 22.sp,color = Color.White)
        }
    }
}




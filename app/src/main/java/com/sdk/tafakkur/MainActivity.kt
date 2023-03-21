package com.sdk.tafakkur

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.sdk.tafakkur.ui.navigation.RootNavigation
import com.sdk.tafakkur.ui.theme.TafakkurTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TafakkurTheme(
            ) {
                RootNavigation(navHostController = rememberNavController())
            }
        }
    }
}


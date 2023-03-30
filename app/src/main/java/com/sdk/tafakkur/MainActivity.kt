package com.sdk.tafakkur

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.sdk.tafakkur.ui.navigation.RootNavigation
import com.sdk.tafakkur.ui.theme.TafakkurTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel = viewModels<AdminViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            delay(1000L)
            window.setBackgroundDrawableResource(android.R.color.transparent)
        }
        //viewModel.value.go()
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



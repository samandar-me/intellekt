package com.sdk.tafakkur

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.collectAsState
import androidx.navigation.compose.rememberNavController
import com.sdk.data.manager.DataStoreManager
import com.sdk.tafakkur.ui.navigation.RootNavigation
import com.sdk.tafakkur.ui.theme.TafakkurTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var dataStoreManager: DataStoreManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val isAuthed = dataStoreManager.getAuthState().collectAsState(initial = true)
            TafakkurTheme {
                RootNavigation(
                    navHostController = rememberNavController(),
                    isAuthed = false
                )
            }
        }
    }
}



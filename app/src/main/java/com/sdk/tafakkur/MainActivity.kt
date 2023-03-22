package com.sdk.tafakkur

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.sdk.data.manager.DataStoreManager
import com.sdk.tafakkur.ui.components.LoadingBar
import com.sdk.tafakkur.ui.main.settings.SettingsViewModel
import com.sdk.tafakkur.ui.navigation.RootNavigation
import com.sdk.tafakkur.ui.theme.TafakkurTheme
import com.sdk.tafakkur.util.Graph
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
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
                    isAuthed = isAuthed.value
                )
            }
        }
    }
}



package com.sdk.tafakkur.ui.main.settings

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sdk.data.manager.DataStoreManager
import com.sdk.domain.use_case.base.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val useCases: UseCases,
    private val manager: DataStoreManager
) : ViewModel() {
    var isAuthed = MutableStateFlow(false)

    init {
        viewModelScope.launch {
            manager.getAuthState().collect {
                isAuthed.value = it
            }
        }
    }
}
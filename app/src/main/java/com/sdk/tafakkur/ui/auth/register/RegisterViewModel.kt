package com.sdk.tafakkur.ui.auth.register

import android.net.Uri
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sdk.tafakkur.util.customCombine
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
): ViewModel() {
    private val fullName = savedStateHandle.getStateFlow("fullName", "")
    private val email = savedStateHandle.getStateFlow("email","")
    private val password = savedStateHandle.getStateFlow("password", "")
    private val isLoading = savedStateHandle.getStateFlow("isLoading", false)
    private val message = savedStateHandle.getStateFlow("message", "")
    private val image = savedStateHandle.getStateFlow("image", Uri.EMPTY)
    private val errorBar = savedStateHandle.getStateFlow("errorBar", false)
    private val successBar = savedStateHandle.getStateFlow("successBar", false)

    val state = customCombine(
        fullName,
        email,
        password,
        isLoading,
        message,
        errorBar,
        successBar,
        image
    ) { fName, email, pass, isL,msg, err, success, image ->
        RegisterState(
            fullName = fName,
            email = email,
            password = pass,
            isLoading = isL,
            message = msg,
            errorBarVisible = err,
            successBarVisible = success,
            image = image
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(4000L), RegisterState())

    fun onFullNameChange(text: String) {
        savedStateHandle["fullName"] = text
    }
    fun onUserNameChange(text: String) {
        savedStateHandle["email"] = text
    }
    fun onPasswordChange(text: String) {
        savedStateHandle["password"] = text
    }
    fun onImageChange(uri: Uri) {
        savedStateHandle["image"] = uri
    }
    fun register() {
        viewModelScope.launch {
            savedStateHandle["message"] = "Error"
            savedStateHandle["errorBar"] = true
            delay(3000L)
            savedStateHandle["errorBar"] = false
        }
    }
}